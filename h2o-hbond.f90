!****************************************************************************
!   计算水分子之间形成的氢键
!  FUNCTION:calculate the number of hydrogen bonds between GO and water molecules
!
!
!  PROGRAM: H_bonds
!
!  HISTORY: 1st version by gsy 2019/10/23
!  
!****************************************************************************

    program Hbond
 	implicit none
	
	integer i,j,k,n_h2o,n,n_atom,l,m,s,p,nz,c
	integer  num,type,nb,nh,nhbond
	real  xl,xh,yl,yh,zl,zh,xlong,ylong,zlong
	real  x(1000,300,3),y(1000,300,3),z(1000,300,3)
	real  wx(2,3),wy(2,3),wz(2,3)
	real w_o(2,3),w_h(4,3),w(2000,300,3,3)
	real  d2,rrsoh,rrgoh,cosoh,cos30
	logical  hbond_exist
	parameter(n_h2o=281,n_atom=843,n=852)
		
!!!!cccccc###########################################

	
	open(1, file = './nvt1.atom')   !读取文件
	
	                 
	open(10, file = './hb.txt')     !作为输出文件
	
	
!ccccc############################################

  
  nz=n*999
do s = 1 , 1001       !!!总共有2001个构型  前1001个构型舍弃
		do i = 1,5       !!!!前5行不需要
			read(1,*)
		end do 
			read(1,*)xl,xh    !!!!盒子的尺寸
			read(1,*)yl,yh
			read(1,*)zl,zh
			read(1,*)        !!!!第9行不需要
		do i = 1,n_atom
			read(1,*)
		end do
end do 
	xlong=xh-xl
 	 ylong=yh-yl
  	zlong=zh-zl
do i = 1,1000       !!!使用剩下的1000个构型用作计算
	do k = 1 , 9      !!!!前9行不需要
		read(1,*)
	end do
	do k = 1 , n_h2o    !!!总共有n_h2o个水分子
		do l = 1 , 3     !!!每个水分子由三个原子组成   
			read(1,*)num,type,w(i,k,l,1),w(i,k,l,2),w(i,k,l,3)    !!!!  i构型数，k第几个水分子，l为1,2,3代表O.H.H

			if (w(i,k,l,1)<xl) then      !!!周期性
				w(i,k,l,1)=w(i,k,l,1)+xlong
			end if
			if (w(i,k,l,2)<yl) then
				w(i,k,l,2)=w(i,k,l,2)+ylong
			end if
			if (w(i,k,l,3)<zl) then
				w(i,k,l,3)=w(i,k,l,3)+zlong
			end if
			
			if (w(i,k,l,1)>xh) then
				w(i,k,l,1)=w(i,k,l,1)-xlong
			end if
			if (w(i,k,l,2)>yh) then
				w(i,k,l,2)=w(i,k,l,2)-ylong
			end if
			if (w(i,k,l,3)>zh) then
				w(i,k,l,3)=w(i,k,l,3)+zlong
			end if
			
		end do 
	end do
end do

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!计算氢键
do m = 1 , 1000   !!!对应前面读取的1000个构型
	nh=0
	
	do i = 1 , n_h2o
 		do j = i+1 , n_h2o   !!!计算两个不同的水分子之间
 			!if (i/=j) then
 					do c = 1 ,3  !代表x,y,z
            w_o(1,c)=w(m,i,1,c)
						w_h(1,c)=w(m,i,2,c)
						w_h(2,c)=w(m,i,3,c)
						w_o(2,c)=w(m,j,1,c)
						w_h(3,c)=w(m,j,2,c)
						w_h(4,c)=w(m,j,3,c)   !!!!降维   将4维数组变成2维数组  方便计算
 					end do
 					
 					
 				call hbond_wo(w_o,w_h,hbond_exist,nb)   !!!!调用子程序  然后返回nb（nb表示形成的氢键个数）   子程序在最下面
					!if (hbond_exist) then       
						nh=nh+nb        !!!!计数
					!write(10,*)m,i,j,nb
 				
						if (nb>3) then      !!!只是为了调试程序  没实际作用 
							write (*,*) m,i,j,nb
						end if
					!end if
 			!end if 
 		end do
	!write(*,*) m,i,nh
	
	end do
		!nhbond=nh/2
		
		write(10,*)m,nh     !!!输出每个构型水分子形成的氢键个数
end do

end

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

!!!!!下面为计算氢键算法的子程序

!***************************!	subroutine	hbond_wo	!************************************

	subroutine hbond_wo(w_o,w_h,hbond_exist,nb)
	implicit none
	integer p,nb,m
	real  wx(2,3),wy(2,3),wz(2,3)
	real w_o(2,3),w_h(4,3),rr_o_h(4),rr_woh(4)
	real  d2,rrsoh,rrgoh,cos_o_oh,cos30
	logical hbond_exist

	cos30 = sqrt(3.)/2.      !!！定义COS30
	hbond_exist = .false.     !!!逻辑定义
	nb=0
	d2=(w_o(1,1)-w_o(2,1))**2+(w_o(1,2)-w_o(2,2))**2+(w_o(1,3)-w_o(2,3))**2
 	if (d2<3.5**2) then

		do m = 1, 2
			rr_o_h(m) = (w_h(m,1)-w_o(2,1))**2 + (w_h(m,2)-w_o(2,2))**2+(w_h(m,3)-w_o(2,3))**2
			rr_woh(m) = (w_o(1,1)-w_h(m,1))**2+(w_o(1,2)-w_h(m,2))**2+(w_o(1,3)-w_h(m,3))**2
		enddo
		
		do m = 3, 4
			rr_woh(m) = (w_h(m,1)-w_o(2,1))**2 + (w_h(m,2)-w_o(2,2))**2+(w_h(m,3)-w_o(2,3))**2
			rr_o_h(m) = (w_o(1,1)-w_h(m,1))**2+(w_o(1,2)-w_h(m,2))**2+(w_o(1,3)-w_h(m,3))**2
		enddo

		do m = 1, 4
			cos_o_oh = (d2+rr_woh(m)-rr_o_h(m))/(2.*sqrt(d2)*sqrt(rr_woh(m)))   !!!以供体O作为夹角
			if (cos_o_oh > cos30)then
				hbond_exist = .true.
				nb=nb+1
			endif
		enddo



	end if
	return     !!!将hbond_exist以及nb带回主程序中
	
	end subroutine hbond_wo   !!!!结束子程序



   
!****************************************************************************
!   ����ˮ����֮���γɵ����
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

	
	open(1, file = './nvt1.atom')   !��ȡ�ļ�
	
	                 
	open(10, file = './hb.txt')     !��Ϊ����ļ�
	
	
!ccccc############################################

  
  nz=n*999
do s = 1 , 1001       !!!�ܹ���2001������  ǰ1001����������
		do i = 1,5       !!!!ǰ5�в���Ҫ
			read(1,*)
		end do 
			read(1,*)xl,xh    !!!!���ӵĳߴ�
			read(1,*)yl,yh
			read(1,*)zl,zh
			read(1,*)        !!!!��9�в���Ҫ
		do i = 1,n_atom
			read(1,*)
		end do
end do 
	xlong=xh-xl
 	 ylong=yh-yl
  	zlong=zh-zl
do i = 1,1000       !!!ʹ��ʣ�µ�1000��������������
	do k = 1 , 9      !!!!ǰ9�в���Ҫ
		read(1,*)
	end do
	do k = 1 , n_h2o    !!!�ܹ���n_h2o��ˮ����
		do l = 1 , 3     !!!ÿ��ˮ����������ԭ�����   
			read(1,*)num,type,w(i,k,l,1),w(i,k,l,2),w(i,k,l,3)    !!!!  i��������k�ڼ���ˮ���ӣ�lΪ1,2,3����O.H.H

			if (w(i,k,l,1)<xl) then      !!!������
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

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!�������
do m = 1 , 1000   !!!��Ӧǰ���ȡ��1000������
	nh=0
	
	do i = 1 , n_h2o
 		do j = i+1 , n_h2o   !!!����������ͬ��ˮ����֮��
 			!if (i/=j) then
 					do c = 1 ,3  !����x,y,z
            w_o(1,c)=w(m,i,1,c)
						w_h(1,c)=w(m,i,2,c)
						w_h(2,c)=w(m,i,3,c)
						w_o(2,c)=w(m,j,1,c)
						w_h(3,c)=w(m,j,2,c)
						w_h(4,c)=w(m,j,3,c)   !!!!��ά   ��4ά������2ά����  �������
 					end do
 					
 					
 				call hbond_wo(w_o,w_h,hbond_exist,nb)   !!!!�����ӳ���  Ȼ�󷵻�nb��nb��ʾ�γɵ����������   �ӳ�����������
					!if (hbond_exist) then       
						nh=nh+nb        !!!!����
					!write(10,*)m,i,j,nb
 				
						if (nb>3) then      !!!ֻ��Ϊ�˵��Գ���  ûʵ������ 
							write (*,*) m,i,j,nb
						end if
					!end if
 			!end if 
 		end do
	!write(*,*) m,i,nh
	
	end do
		!nhbond=nh/2
		
		write(10,*)m,nh     !!!���ÿ������ˮ�����γɵ��������
end do

end

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

!!!!!����Ϊ��������㷨���ӳ���

!***************************!	subroutine	hbond_wo	!************************************

	subroutine hbond_wo(w_o,w_h,hbond_exist,nb)
	implicit none
	integer p,nb,m
	real  wx(2,3),wy(2,3),wz(2,3)
	real w_o(2,3),w_h(4,3),rr_o_h(4),rr_woh(4)
	real  d2,rrsoh,rrgoh,cos_o_oh,cos30
	logical hbond_exist

	cos30 = sqrt(3.)/2.      !!������COS30
	hbond_exist = .false.     !!!�߼�����
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
			cos_o_oh = (d2+rr_woh(m)-rr_o_h(m))/(2.*sqrt(d2)*sqrt(rr_woh(m)))   !!!�Թ���O��Ϊ�н�
			if (cos_o_oh > cos30)then
				hbond_exist = .true.
				nb=nb+1
			endif
		enddo



	end if
	return     !!!��hbond_exist�Լ�nb������������
	
	end subroutine hbond_wo   !!!!�����ӳ���



   
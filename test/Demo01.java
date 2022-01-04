public class Demo01 {
	public static void main(String[] args){
		int sum01 = 0;
		int sum02 = 0;
		int sum03 = 0;
		
		for (int i = 1;i <= 100;i++){
			if (i % 2 == 0){
				sum01 +=i;
			}
		}
		
		int i = 1;
		while(i <= 100){
			if (i % 2 == 0){
				sum02 +=i;
			}
			i++;
		}
		
		int j = 1;
		do{
			if (j % 2 == 0){
				sum03 +=j;
			}
			j++;
		}while(	j <= 100);
		
		System.out.println("结果是："+ sum01);
		System.out.println("结果是："+ sum02);
		System.out.println("结果是："+ sum03);
		System.out.println("===============");
	}
}
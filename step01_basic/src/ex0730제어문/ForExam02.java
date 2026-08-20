package ex0730제어문;

public class ForExam02 {

	public static void main(String[] args) {
		//1.  1 ~ 100가지 10행 10열로 출력 (for문 안에 for문이용)
		int a = 1;
		for(int i=1 ; i<11; i++){
			for(int j=1 ; j<11;j++){
				System.out.print(a+" ");
				a++;
			}
			System.out.println();}
		
	
		
		//2. 1 ~ 100가지 10행 10열로 출력 (for문 안에  if문이용)
		
		System.out.println("\n2. 1 ~ 100가지 10행 10열로 출력 (for문 안에 if문이용)");
		
		
		int b = 1;
		for(int i = 1; i < 101; i++) {
			if(i % 10 != 0) {
				System.out.print(b + "\t");
				b++;
			} else {
				System.out.println(b);
				b++;
			}
		}
		
		
		//3. 구구단 출력  -  for 문안에 for문이용
		/*
				 *
				 *  2*1=2  3*1=3 ..... 9*1=9
				 *  2*2=4  3*2=4  4*2=4
				 *  2*3=6
				 *  ..
				 *
				 *  2*9=18              9*9=81
				 *
				 * */
		int c = 1;
		for(c = 1; c<10;c++) {
			for(int j = 2; j< 10; j++) {
				System.out.print(j + " * " + c + " = " + (j*c) + "\t");
			}
			System.out.println();
		}
	}
}
	


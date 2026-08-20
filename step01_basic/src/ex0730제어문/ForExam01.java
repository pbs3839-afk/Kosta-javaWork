package ex0730제어문;

public class ForExam01 {

	public static void main(String[] args) {
		// 1. 1~100가지 한줄로 출력
		
		int a;
		for(a = 1  ; a<=100  ; a++  ){
			  System.out.print(a);;
	}
		
		
		// 2. A~Z 까지 한줄로 출력
		System.out.println();
		System.out.println();
		
		
		for(a = 0  ; a <=25  ; a++  ){
			char bab ='A';
			
		  System.out.print((char)(bab+a));
		}
		for(char ch ='A'; ch <='Z'  ; ch++  ){
			System.out.print(ch);
		}
		
		
		
		
		System.out.println();
		System.out.println();
		
		
		// 3. 1~10 까지 합 구해서 출력
		int sum=0;
		
		for(a=1; a<=10; a++) {
			sum+= a;
		
		}
		System.out.print(sum);;
		
		
		
		
		System.out.println();
		System.out.println();
		// 4. 1~ 100 사이의 7의 배수만 출력
		
		for(a=7; a<=100; a+=7) {
			System.out.println(a+'\t');
		}
		
		
		
		
		
		
		System.out.println();
		System.out.println();
		// 5. 100~ 1 사이의 5의 배수만 출력
		
		for(a=100; a>=1; a--) {
			if(a%5==0)System.out.println(a+"\t");
		}
		
		///////////////////////////////////////////////
		System.out.println();
		System.out.println();
		
		for(int i=1;i<=3;i++){
			for(int b=1 ; b<=5;b++){
				System.out.println('b');
			}
			System.out.println();
		}
		System.out.println();
		
		
		}
}


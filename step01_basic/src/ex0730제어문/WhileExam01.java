package ex0730제어문;

public class WhileExam01 {
	public static void main(String[] args) {
		//1. 1~ 100가지 한줄로 출력
		int a = 1;
		while(a<101){
		  System.out.print(a);
		  a++;
		}

		System.out.println();
		System.out.println();
		//2. A ~Z 까지 한줄로 출력
		
			a = 0;       // 초기화
			char b = 'A';
			while(a<26){
				  System.out.print((char)(b+a));
				  a++;
				}
	
		//3. 1~ 10 까지  합 구해서 출력
			
			int sum = 0;
			a = 1;

			while (a <= 10) {
			    sum += a;
			    a++;
			}

			System.out.print(sum);

		//4. 1 ~ 100 사이의 7의 배수만 출력 

		//5. 100 ~ 1 사이의 5 의 배수만 출력 

		//1.  1 ~ 100가지 10행 10열로 출력 (While문 안에 While문이용)
		//2. 1 ~ 100가지 10행 10열로 출력 (While문 안에  if문이용)

		//3. 구구단 출력  -  While 문안에 While문이용
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
	}
	}


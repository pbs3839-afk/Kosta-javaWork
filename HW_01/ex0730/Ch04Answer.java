package ex0730;

import java.util.Scanner;

public class Ch04Answer {

	public static void main(String[] args) {

		//1. 2
		//2.
		
		String grade = "B";

		int score1 = switch (grade) {
			case "A" -> 100;
			case "B" -> (100-20);
			default -> 60;
		};
		//3. 
		int sum = 0;
		for(int a=1; a<=100; a++) {
			if(a%3==0) {
				sum=sum+a;
			}
		} System.out.println(sum);
		
		//4. 
		
		while(true) {
			int number1 = (int)(Math.random() * 6 + 1);
			int number2 = (int)(Math.random() * 6 + 1);
			if(number1+number2==5) {
				break;
			}
		} 
		
		//5.
		int x,y;
		
		for(x = 1  ; x <=10  ; x++ ){
			for(y=1; y <= 10 ; y++) {
				if(4*x+5*y==60) {
					System.out.println("(" + x + "," + y + ")");
				}
			}
		}
			
		//6.
		for(int a = 1  ; a <=5  ; a++ ){
			for(int b=1; b <=a ; b++) {
				System.out.print('★');
			}
		  System.out.println();
		} 
		
		
		// 7.
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금액 | 3.잔고 | 4.종료 ");
			System.out.println("------------------------------");
			
			System.out.println("선택 > ");
			int menuChoice = sc.nextInt();
			
			if(menuChoice==1) {
				System.out.println("예금액");
				int money = sc.nextInt();
			}else if(menuChoice==2)	{
				System.out.println("출금액");
				int outMoney = sc.nextInt();
			}else if(menuChoice==3)	{
				System.out.println("잔고");
				int inMoney = sc.nextInt();
			}else if (menuChoice==4) {
				System.out.println("프로그램 종료");
				break;
			} 
}
			
		
			//PDF 
		int a, b;
		
		for(a = 1  ; a <=5  ; a++ ){
			for(b=1; b <=a ; b++) {
				System.out.print('★');
			}
		  System.out.println();
		} System.out.println("*********************");
		
		
		for(a = 1  ; a <=5  ; a++ ){
			for(b=5; b >= a ; b--) {
				System.out.print('★');
			}
		  System.out.println();
		} System.out.println("*********************");
		
		
		for(a = 1  ; a <=5  ; a++ ){
			for(b=1; b <=(5-a) ; b++) {
				System.out.print(' ');
			}
			for(b=1; b <= a; b++) {
				System.out.print('★');
			}
		  System.out.println();
		} System.out.println("*********************");
		
		for(a = 0  ; a <=5  ; a++ ){
			for(b=1; b <= a; b++) {
				System.out.print(' ');
			}
			for(b=1; b <=(5-a) ; b++) {
				System.out.print('★');
			}
		  System.out.println();
		} System.out.println("*********************");
		
	
	
	
	
	
	}
}

 package ex0730scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in); // ctrl + shift + o
		
		while(true) {
				System.out.println("1.성적표       2.종료");
		System.out.println("메뉴선택 > ");
		int menuChoice = sc.nextInt();
		
		if(menuChoice==1) {
		System.out.println("이름은?");
		String name = sc.next();
		
		System.out.println("국어점수 입력?");
		int kor = sc.nextInt();
		
		System.out.println("영어점수 입력?");
		int eng = sc.nextInt();
		
		
		System.out.println("***"+name+"님 성적표 *****");
		System.out.println("국어점수 = " + kor);
		System.out.println("영어점수 = " + eng);
		System.out.println("총합 : " +(kor+eng));
		System.out.println("*********");
		}else if(menuChoice==2)	{
			break; // while 탈출
		}else {
			System.out.println("메뉴는 1~2만 입력하세요");
		}
		
		
		
	}
	}
}

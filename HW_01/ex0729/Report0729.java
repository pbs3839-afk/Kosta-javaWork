package ex0729;

public class Report0729 {
	public static void main(String[] args) {
		String name = "beomsoo";
		int kor = (int)(Math.random() * 56 + 45);
		int math = (int)(Math.random() * 56 + 45);
		int eng = (int)(Math.random() * 56 + 45);
		int sum = kor+math+eng;
		double avg = sum/3.0;
		char grade = 'F';
		
		if(avg>=90) {
			grade = 'A';
		}else if((avg >=80) && (avg <= 89)) {
			grade = 'B';
		}else if((avg >=70) && (avg <= 79)) {
			grade = 'C';
		}else if((avg >=60) && (avg <= 69)) {
			grade = 'D';
		}
		System.out.println(name + "님");
		System.out.println("국어점수: " + kor);
		System.out.println("수학점수" + math);
		System.out.println("영어점수" + eng );
		System.out.println("총점" + sum );
		System.out.println("평균" + avg );
		System.out.println("학점" + grade );
		
		char grade2 = 'F';
		switch((int)avg/10){
		case 10, 9: grade2 = 'A'; break;
	    case 8: grade2 = 'B' ; break;
	    case 7: grade2 = 'C' ; break;
	    case 6: grade2 = 'D' ;break;
	    default : grade2 = 'F';
		}
	    
	    System.out.println(name + "님");
		System.out.println("국어점수: " + kor);
		System.out.println("수학점수" + math);
		System.out.println("영어점수" + eng );
		System.out.println("총점" + sum );
		System.out.println("평균" + avg );
		System.out.println("학점" + grade2 );
	}
}
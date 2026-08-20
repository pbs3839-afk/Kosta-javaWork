package ex0814.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
	
	public MemberSetExam() {
		/**
		 * 다른 객체라도 hashCode() 메소드의 리턴값이 같고,
		 * equals() 메소드가 true를 리턴하면 동일한 객체라고
		 * 판단하고 중복 저장하지 않음
		 * */
		set.add(new Member("희정1", 10, "서울"));
		set.add(new Member("희정2", 20, "대구"));
		set.add(new Member("희정3", 30, "대전"));
		
		System.out.println("저장된 객체의 수 = " + set.size());
	}
	public static void main(String[] args) {
		new MemberSetExam();

	}
	
}









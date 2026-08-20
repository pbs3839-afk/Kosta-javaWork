package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExam03 extends ArrayList<Emp> {
	public ListExam03() {
		// 사원 저장
		super.add(new Emp(20, "희정", 20, "서울"));
		super.add(new Emp(10, "나영", 25, "대구"));
		super.add(new Emp(30, "미미", 22, "대전"));
		super.add(new Emp(40, "삼순", 28, "서울"));
		super.add(new Emp(50, "순돌", 26, "부산"));

	}

	/**
	 * 저장된 모든 사원의 정보 검색
	 */
	public List<Emp> selectAll() {
		return this;
	}

	/**
	 * 사원의 사원번호에 해당하는 사원정보 검색
	 * 
	 * @return : 있으면 Emp객체 , 없으면 null
	 */
	public Emp selectByEmpno(int empno) {
		for (Emp e : this) {
			if (e.getEmpno() == empno)
				return e;
		}
		return null;
	}

	/**
	 * 주소를 인수로 전달받아 동일한 주소에 해당하는 사원정보 검색
	 */
	public List<Emp> selectByAddr(String addr) {
		List<Emp> findList = new ArrayList<Emp>();

		for (Emp e : this) {
			if (e.getAddr().equals(addr)) {
				findList.add(e);
			}

		}
		return findList;
	}

	/**
	 * 사원번호를 기준으로 사원정보 정렬하기
	 */
	public List<Emp> sortByEmpno() {
		// All elements in
		// the list must implenent the Comparable
		// => Integer는 이미 Comparable 구현한 객체이다.
		// sort를 하기위한 객체는 반드시 Comparable 구현한 객체여야한다.
		// Collections.sort(this); // 우너본이 정렬이 되어서 등록된 순서를 이후로 알수 없다.
		// 정렬을 해줄 새로운 List 를 만들고 그 list를 정렬해서 리턴한다.
		List<Emp> shallowCopy = new ArrayList<Emp>(this);
		Collections.sort(shallowCopy);
		return shallowCopy;
	}

	/**
	 * 나이를 기준으로 사원정보 정렬하기
	 */
	public List<Emp> sortByAge() {
		List<Emp> shallowCopy = new ArrayList<Emp>(this);
		//Collections.sort(shallowCopy, new Test());
		
		//익명이너타입으로 선언하기
		/*Collections.sort(shallowCopy, new Comparator<Emp>() {

			@Override
			public int compare(Emp o1, Emp o2) {
				// TODO Auto-generated method stub
				return o2.getAge()- o1.getAge();
			}
		});*/
		//람다식
		Collections.sort(shallowCopy,(o1,o2)->o2.getAge()-o1.getAge());
		return shallowCopy;
	}

	public static void main(String[] args) {
		ListExam03 ex = new ListExam03();
		List<Emp> list = ex.selectAll();
		for (Emp e : list) {
			System.out.println(e);
		}
		System.out.println("*------------------------------------------------*");
		////////////////////////////////////////////////////////////////

		for (int i = 0; i < list.size(); i++) {
			Emp e = list.get(i);
			System.out.println(e);
		}
		////////////////////////////////////////////////////////////////
		System.out.println("/n2. 사원번호에 해당하는 사원정보 검색--");
		Emp e = ex.selectByEmpno(40);
		System.out.println(e);
		////////////////////////////////////////////////////////////////////
		System.out.println("/n3. 주소를 인수로 전달받아 동일한 주소에 해당하는 사원정보 검색--");
		List<Emp> findList = ex.selectByAddr("대전");
		System.out.println(findList);
		////////////////////////////////////////////////////////////////////
		System.out.println("/n4. 사원번호를 기준으로 사원정보 정렬하기--");
		List<Emp> sortedList = ex.sortByEmpno();
		for (Emp emp : sortedList) {
			System.out.println(emp);
		}
		System.out.println("/n5. 정렬 후 전체 검색--");
		sortedList = ex.selectAll();
		for (Emp emp : sortedList) {
			System.out.println(emp);
		}
		System.out.println("/n6. 나이로 정렬 전체검색--");
		sortedList = ex.sortByAge();
		for (Emp emp : sortedList) {
			System.out.println(emp);
		}

	}

}
///////////////////////////////////////////////////////////////////

class Test implements Comparator<Emp> {

	@Override
	public int compare(Emp o1, Emp o2) {
		// TODO Auto-generated method stub
		return o1.getAge() - o2.getAge(); // 음수 or 0 or 양수
	}

}
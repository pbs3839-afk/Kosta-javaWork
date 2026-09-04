package kosta.db.view;

import java.util.List;

import kosta.db.dao.EmpDAO;
import kosta.db.dto.EmpDTO;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("**JDBC 시작하기***");
		EmpDAO dao = new EmpDAO();
		//dao.selectNames();
		
		System.out.println("***삭제하기***");
		//dao.deleteByEmpno(7566);
		dao.deleteByEmpno2(7698);
		
		System.out.println("***검색하기****");
		List<EmpDTO> list = dao.selectAll();
		
		list.forEach(System.out :: println);
		
		System.out.println("***검색하기****");
		dao.selectByEmpno(7499);
		System.out.println(dao.selectByEmpno(7499));
		
		System.out.println("***등록하기****");
		dao.insert(new EmpDTO(1000,"박범수","포크레인",9999, null));
		
	}

}

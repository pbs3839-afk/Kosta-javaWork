package kosta.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kosta.db.dto.EmpDTO;
import kosta.db.util.DbManager;

public class EmpDAO {
	/**
	 * emp 테이블에서 사원의 모든 이름 검색
	 */

	public void selectNames() {
		// 로드 연결 실행 닫기
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select ename from emp");
			while(rs.next()) {//앞으로 커서가 이동한다면 ( 이동할수 있을동안 반복한다)
				//열을 조회한다.
				String ename =  rs.getString("ename");
				System.out.println(ename);
			}
			System.out.println("**완료**");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st, rs);
		}
	}
	
	/**
	 * 사원번호에 해당하는 레코드 삭제
	 * delete from emp where empno = 1000;
	 * */
	public void deleteByEmpno(int empno) {
		Connection con = null;
		Statement st = null;
		String sql = "delete from emp where empno =" + empno;
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			int re = st.executeUpdate(sql);
			
			if (re==0) System.out.println(re + "삭제되지 않았습니다.");
			else System.out.println(re + "삭제되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, st);
		}
		
	}
	/////위 delete를 PreparedStatement 방식으로 변경해보자/////////////////////////////////////////////////////////////////////
	public void deleteByEmpno2(int empno) {
			Connection con = null;
			PreparedStatement ps = null;
			String sql = "delete from emp where empno=?";
			try {
				con = DbManager.getConnection();
				ps = con.prepareStatement(sql);
				//?의 개수만큼 순서대로 setXxx()설정 필수
				ps.setInt(1, empno);
				
				// 실행요청
				int re = ps.executeUpdate();
				if (re==0) System.out.println(re + "삭제되지 않았습니다.");
				else System.out.println(re + "삭제되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DbManager.dbClose(con, ps);
			}
			
		
	}

	/**
	 * 모든 사원의 정보 검색하기
	 * */
	public List<EmpDTO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select empno,ename , job,sal ,hiredate from emp";
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				//열을 조회
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				
				EmpDTO dto = new EmpDTO(empno,ename,job,sal,hiredate);
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps, rs);
		}
		
		return list;
	}
	
	/**
	 * 사원번호에 해당하는 사원정보 검색하기
	 * select empno,ename , job,sal ,hiredate from emp where empno=?
	 * */
	/*
	 * public EmpDTO selectByEmpno(int empno) { Connection con = null;
	 * PreparedStatement ps = null; ResultSet rs = null; String sql =
	 * "select empno,ename,job,sal,hiredate from emp where empno=?";
	 * 
	 * try { con = DbManager.getConnection(); ps = con.prepareStatement(sql);
	 * ps.setInt(1, empno); rs = ps.executeQuery();
	 * 
	 * while(rs.next()) { //열을 조회 int empno1 = rs.getInt("empno"); String ename =
	 * rs.getString("ename"); String job = rs.getString("job"); int sal =
	 * rs.getInt("sal"); String hiredate = rs.getString("hiredate"); EmpDTO dto =
	 * new EmpDTO(empno1,ename,job,sal,hiredate); return dto;
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }finally {
	 * DbManager.dbClose(con, ps, rs); }
	 * 
	 * return null; }
	 */
	public EmpDTO selectByEmpno(int empno){

	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    String sql = "select empno, ename, job, sal, hiredate from emp where empno = ? ";

	    EmpDTO empDto = null;

	    try{

	        connection = DbManager.getConnection();
	        preparedStatement = connection.prepareStatement(sql);

	        preparedStatement.setInt(1,empno);

	        resultSet = preparedStatement.executeQuery();

	        if(resultSet.next()){
	            /*
	            int no = resultSet.getInt("empno");
	            String name = resultSet.getString("ename");
	            String job = resultSet.getString("job");
	            int sal = resultSet.getInt("sal");
	            String date = resultSet.getString("hiredate");*/

	            //empDto = new EmpDto(no, name, job, sal, date);
	            empDto = new EmpDTO( resultSet.getInt("empno"),resultSet.getString("ename"),resultSet.getString("job"),
	                    resultSet.getInt("sal"), resultSet.getString("hiredate"));

	        }

	        return empDto;

	    }catch (Exception e){

	    }finally {
	        DbManager.dbClose(connection,preparedStatement,resultSet);
	    }

	    return  null;
	}
	/**
	 * 사원정보 등록하기
	 * insert into emp(empno,ename ,job, sal , hiredate) values(?,?,?,?,now());
	 * */
	public int insert(EmpDTO empDTO) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into emp(empno,ename ,job, sal , hiredate) values(?,?,?,?,now())";
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, empDTO.getEmpno());
			ps.setString(2, empDTO.getEname());
			ps.setString(3, empDTO.getJob());
			ps.setInt(4, empDTO.getSal());
			
			int re = ps.executeUpdate();
			if (re==0) System.out.println(re + "등록되지 않았습니다.");
			else System.out.println(re + "등록되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbManager.dbClose(con, ps);
		}
		
		
		return 0;
	}
	
	
}

package subject.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import subject.db.vo.Room;
import subject.db.vo.Student;
import subject.db.vo.Subject;
import subject.db.vo.Teacher;
import util.DbManager;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {
	public List<Student> getGenderByWomen() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from student where sjumin like '%-2%'";

		List<Student> list = new ArrayList<Student>();
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {// 앞으로 커서가 이동한다면 ( 이동할수 있을동안 반복한다)
				int studentNo = rs.getInt("sNo");
				String studentName = rs.getString("sName");
				String studentJumin = rs.getString("sjumin");
				String studentPhone = rs.getString("sNumber");
				String studentAddr = rs.getString("sAddr");
				String studentEmail = rs.getString("sEmail");

				Student student = new Student(studentNo, studentName, studentJumin, studentPhone, studentAddr,
						studentEmail);
				list.add(student);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		return list;
	}

	public List<Teacher> getTeacherInfoByAddr(String gu) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from teacher  where tAddr like ?";

		List<Teacher> list = new ArrayList<Teacher>();
		try {
			con = DbManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + gu + "%");
			rs = ps.executeQuery();

			while (rs.next()) {// 앞으로 커서가 이동한다면 ( 이동할수 있을동안 반복한다)
				// 열을 조회한다
				int teacherNo = rs.getInt("tNo");
				String teacherName = rs.getString("tName");
				String teacherJumin = rs.getString("tjumin");
				String teacherPhone = rs.getString("tNumber");
				String teacherAddr = rs.getString("tAddr");
				String teacherEmail = rs.getString("tEmail");
				String sugangCode = rs.getString("takecode");

				Teacher teacher = new Teacher(teacherNo, teacherName, teacherJumin, teacherPhone, teacherAddr,
						teacherEmail, sugangCode);
				list.add(teacher);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, rs);
		}
		return list;
	}

	public Teacher getTeacherInfoBySubject(String subject) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from teacher where takecode = (select takecode from subject where upper(subject)=upper( ? ))";

		Teacher teacher = null;

		try {
			connection = DbManager.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, subject);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				teacher = new Teacher(resultSet.getInt("tNO"), resultSet.getString("tName"),
						resultSet.getString("tjumin"), resultSet.getString("tNumber"), resultSet.getString("tAddr"),
						resultSet.getString("tEmail"), resultSet.getString("takecode"));
			}
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(connection, preparedStatement, resultSet);
		}
		return null;
	}

	/**
	 * 8강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다 select * from v_teacherInfo where
	 * 강사번호=?
	 * 
	 */
	public Teacher getTeacherInfoByNo(int teacherNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "select * from v_tear where tNo=?";
		Teacher teacher = null;

		try {
			connection = DbManager.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, teacherNo);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				teacher = new Teacher();

				teacher.settNO(resultSet.getInt("tNO"));
				teacher.settName(resultSet.getString("tName"));
				teacher.setTakecode(resultSet.getString("takecode"));
				teacher.setSubject(new Subject(resultSet.getString("takecode"), resultSet.getString("subject")));
				teacher.setRoom(new Room(resultSet.getInt("roomNo"), resultSet.getInt("capacity")));

			}
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(connection, preparedStatement, resultSet);
		}
		return null;
	}
}
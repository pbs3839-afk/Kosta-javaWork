package ex0805.constructor.student;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	private Student stArr [] = new Student [5];
	
	// 배열방에서 저장된 객체의 개수를 저장하는 변수 
	public static int count;
	
	/**
	 * 초기치 데이터 3명 정도 세팅하기 
	 * */
	public StudentService(String [][] data) {
		for(int i = 0;i< data.length ; i++) {
			stArr[count++] = this.create(data[i]);
		}
	}
	
	/**
	 * Student 객체를 생성해서 리턴해주는 메소드 작성
	 * */
	 private Student create(String [] row) { // {"희정","20","대구"}
		 Student st = new Student(row[0],Integer.parseInt(row[1]),row[2]);
		 
		 return st;
	 }
	
	 /**
	   학생의 정보 등록하기 
	   	: 학생의 이름이 중복이면 등록할수 없다.
	    : 배열의 경계를 벗어나면 더이상 추가할수 없습니다. 
	    : 이외에는 추가를한다.
	  	@return : int  
	  			  0이면 중복이다, -1이면 더이상등록불가, 1이면 성공이다.
	  *
	  **/
	 public int insert(Student student) {
		 if(count== stArr.length)return -1;
		 Student searchedStudent = this.selectByName(student.getName());
		 if(searchedStudent !=null)return 0;
		 stArr[count++] = student;
		 return 1; // 성공
	 }
	 
	/**
	 * 전체 학생의 정보 조회하기
	 * */
	 public Student [] selectAll() {
		 return stArr;
	 }
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소 = Student 를 리턴하고
	 *     없으면 null return
	 * */
	 public Student selectByName(String name) {
		 
		 int foundIndex = -1;
		 
		 for(int i=0; i< count; i++) {
			 if(stArr[i].getName().equals(name)) {
				foundIndex = i;
			 }
		 }
		 if(foundIndex >=0) {
			 return stArr[foundIndex];
		 }else {
			 return null;
		 }
		 
	 }
	
	
	/**
	 *  이름에 해당하는 학생의 나이와 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할수 없습니다." 출력
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
	 *   "수정되었습니다" 출력
	 *   @param : Student
	 *   @return : boolean
	 *   			true면 수정성공, false수정실패
	 * */
	 public boolean update(Student student) {//이름 주소
		
		 	Student searchSt = this.selectByName(student.getName() );
		 if(searchSt==null)return false;

		 searchSt.setAddr(student.getAddr());
		 return true;
			 }
		
}

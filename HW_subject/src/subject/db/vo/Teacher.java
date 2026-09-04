package subject.db.vo;

public class Teacher {

	private int tNO;
	private String tName;
	private String tjumin;
	private String tNumber;
	private String tAddr;
	private String tEmail;

	private String takecode;

	// 과목정보
	private Subject subject;

	// 강의실정보
	private Room room;

	@Override
	public String toString() {
		return "Teacher [tNO=" + tNO + ", tName=" + tName + ", tjumin=" + tjumin + ", tNumber=" + tNumber + ", tAddr="
				+ tAddr + ", tEmail=" + tEmail + ", takecode=" + takecode + ", subject=" + subject + ", room=" + room
				+ "]";
	}

	public Teacher() {

	}

	public Teacher(int tNO, String tName, String tjumin, String tNumber, String tAddr, String tEmail, String takecode) {
		super();
		this.tNO = tNO;
		this.tName = tName;
		this.tjumin = tjumin;
		this.tNumber = tNumber;
		this.tAddr = tAddr;
		this.tEmail = tEmail;
		this.takecode = takecode;
	}

	public int gettNO() {
		return tNO;
	}

	public void settNO(int tNO) {
		this.tNO = tNO;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getTjumin() {
		return tjumin;
	}

	public void setTjumin(String tjumin) {
		this.tjumin = tjumin;
	}

	public String gettNumber() {
		return tNumber;
	}

	public void settNumber(String tNumber) {
		this.tNumber = tNumber;
	}

	public String gettAddr() {
		return tAddr;
	}

	public void settAddr(String tAddr) {
		this.tAddr = tAddr;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String getTakecode() {
		return takecode;
	}

	public void setTakecode(String takecode) {
		this.takecode = takecode;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}

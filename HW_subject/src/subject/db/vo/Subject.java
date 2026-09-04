package subject.db.vo;

public class Subject {
	private String takecode;
	private String subject;

	public String getTakecode() {
		return takecode;
	}

	public void setTakecode(String takecode) {
		this.takecode = takecode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Subject [takecode=" + takecode + ", subject=" + subject + "]";
	}

	public Subject(String takecode, String subject) {
		super();
		this.takecode = takecode;
		this.subject = subject;
	}

}

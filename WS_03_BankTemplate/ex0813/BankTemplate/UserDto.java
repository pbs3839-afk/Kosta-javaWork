package ex0813.BankTemplate;
/**
 *  고객의 정보를 관리할 객체 
 * */
public class UserDto {
	private int userSeq; //고객 일련번호 
	private String name;//고객 이름  
	private String emalil;//이메일 
	private String phone;//연락처 
	private boolean isSleep; // 
	
	public UserDto(int userSeq, String name, String emalil, String phone, boolean isSleep) {
		this.userSeq = userSeq;
		this.name = name;
		this.emalil = emalil;
		this.phone = phone;
		this.isSleep= isSleep;
	}
	public UserDto() {
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmalil() {
		return emalil;
	}
	public void setEmalil(String emalil) {
		this.emalil = emalil;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isSleep() {
		return isSleep;
	}
	public void setSleep(boolean isSleep) {
		this.isSleep = isSleep;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDto [userSeq=");
		builder.append(userSeq);
		builder.append(", name=");
		builder.append(name);
		builder.append(", emalil=");
		builder.append(emalil);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", isSleep=");
		builder.append(isSleep);
		builder.append("]");
		return builder.toString();
	}  
	
}

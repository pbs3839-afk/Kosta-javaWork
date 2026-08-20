package ex0811.exam;

public class Audio extends Elec implements ElecFunction{
	private int volumn;

	public Audio (){}
	public Audio(int volumn) {
		this.volumn = volumn;
	}
	public Audio(String code, int cost, int volumn) {
		super(code,cost);
		this.volumn=volumn;
	}
	/**
	 * @param code
	 * @param cost
	 */
	public Audio(String code, int cost) {
		super(code, cost);
		// TODO Auto-generated constructor stub
	}

	public int getVolumn() {
		return volumn;
	}

	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}
	@Override
	public void start() {
			System.out.println(getCode() + super.getClass() + " " );
			}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Audio [volumn=");
		builder.append(volumn);
		builder.append("]");
		return builder.toString();
	}
	
		
}

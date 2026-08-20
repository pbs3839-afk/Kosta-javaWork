package ex0811.exam;

public class Tv extends Elec implements ElecFunction{
	private int chnnel;

	public Tv (){}
	public Tv(int chnnel) {
		this.chnnel = chnnel;
	}
	public Tv(String code, int cost, int volumn) {
		super(code,cost);
		this.chnnel=chnnel;
	}
	
	/**
	 * @param code
	 * @param cost
	 */
	public Tv(String code, int cost) {
		super(code, cost);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
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
		builder.append("Tv [chnnel=");
		builder.append(chnnel);
		builder.append("]");
		return builder.toString();
	}
	
	
}

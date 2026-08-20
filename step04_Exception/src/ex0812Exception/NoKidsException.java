package ex0812Exception;

public class NoKidsException extends Exception {

	static int count;
	public NoKidsException() {
		super("애들은 안돼요~~");
	}
	
	public NoKidsException(String message) {
		super(message);
		count++;
	}
	
}

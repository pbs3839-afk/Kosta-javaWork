package ex0812Exception;

public class ShoppingMall {

	public void enter(int age) throws NoKidsException {
		if (age < 18) {
			 //try {
			throw new NoKidsException(age + "살 님 성인만 오세요");
//			 }catch (Exception1 e) {
//			 System.out.println(e.getMessage());
//			 }
		} else {
			System.out.println(age + "살 님 환영해요");
		}
	}
}

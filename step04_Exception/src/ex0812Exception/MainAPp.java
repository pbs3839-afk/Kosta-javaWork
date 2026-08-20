package ex0812Exception;

import java.util.Random;

public class MainAPp {

	public static void main(String[] args) {
		System.out.println("Open");
		ShoppingMall e2 = new ShoppingMall();

		Random r = new Random();

		for (int i = 0; i < 10; i++) {
			int age = r.nextInt(55) + 1;
			try {
				e2.enter(age);
			} catch (NoKidsException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
		}
		System.out.println("Close");
		System.out.println("예외 개수 = " + NoKidsException.count);
	}
}
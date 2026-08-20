package ex0810.superkeyword;

class Animal {
	int age = 5;
	String bodyColor;

	public void sound() {
		System.out.println("super 의 sound call");
	}

	public void eat() {
		System.out.println("super 의 eat call");
	}
}

//////////////////////////////////////
class Cat extends Animal {
	int age = 10;
	int weight;

	@Override // annotation (클래스,메소드,필드위에 선언)
	public void sound() {
		System.out.println("Cat의 sound call...");
	}

	public void run() {
		System.out.println("Cat의 run call...");
	}

	public void test() {
		System.out.println(age);
		System.out.println(this.age);
		System.out.println(super.age);
		System.out.println("-----------------------------");
		System.out.println(bodyColor);
		System.out.println(this.bodyColor);
		System.out.println(super.bodyColor);
		System.out.println("-----------------------------");
		System.out.println(weight);
		System.out.println(this.weight);
		// System.out.println(super.weight);
		System.out.println("=======메소드 호출=======");

		sound();
		this.sound();
		super.sound();
		System.out.println("-----------------------------");
		eat();
		this.eat();
		super.eat();
		System.out.println("-----------------------------");
		run();
		this.run();
		// super.run();
	}
}

public class InheritanceFieldMethodExam {

	public static void main(String[] args) {
		// Cat cat = new Cat();
		// cat.test();

		//////////////////////////////////////////////////////

		Cat cat = new Cat();
		System.out.println("----외부에서 객체 생성 접근-----------");
		System.out.println(cat.age);
		System.out.println(cat.bodyColor);
		System.out.println(cat.weight);

		cat.sound();
		cat.eat();
		cat.run();

		System.out.println("--------다형성---------");

		Animal an = new Cat(); // 부모 부분만 접근 가능하다.
		System.out.println(an.age);
		System.out.println(an.bodyColor);
		// System.out.println(an.weight); // 캐스팅 필요

		// 재정의된 메소드는 부모타입이라도 재정의된 메소드 호출된다.
		an.sound();
		an.eat();
		// an.run(); // 캐스팅 필요

		System.out.println("an = " + an);

//		if (an instanceof Cat) {
//			Cat c = (Cat) an;// ObjectDownCasting
//			System.out.println("c = " + c);
//
//			System.out.println(c.weight);
//			c.run();
//		}
		
		if (an instanceof Cat c) {
			System.out.println("c = " + c);

			System.out.println(c.weight);
			c.run();
		}
	}
}

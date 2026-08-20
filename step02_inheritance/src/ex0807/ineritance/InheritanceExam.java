package ex0807.ineritance;

class Car{
		public String carname;
		public int cost;
		
		protected void printAttributes(){
			System.out.println("carname="+carname+"\tcost="+cost);
		}
}
/////////////////////////////////////////////////////////////////////////////////////////////////
//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
	//각 클래스에 인수를 받지않는 생성자 작성
	//각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
class EfSonata extends Car{
	
	int i = 10;
	public EfSonata() {
		carname = "efSonata";
		cost = 111111;
	}
}
class Excel extends Car{
	public Excel() {
		carname = "excel     ";
		cost = 222222;
	}
}
class Carnival extends Car{
public Carnival() {
	carname = "carnival";
	cost = 333333;
	}
}
public class InheritanceExam{
	//메인메소드에서 
	public static void main(String[] args) {
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Excel ex = new Excel();
		Carnival cn = new Carnival();
		
		System.out.println("car : " + car);
		System.out.println("ef  : " + ef);
		System.out.println("ex  : " + ex);
		System.out.println("cn  : " + cn);
		
		car.printAttributes();
		ef.printAttributes();
		ex.printAttributes();
		cn.printAttributes();
				
	}
		//Car, EfSonata, Excel, Carnival 네개의 객체를 생성
		// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
		
	
}


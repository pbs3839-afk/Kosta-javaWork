package ex0810.abstract_final;

final class FinalClassExam{ // 상속불가 생성가능
 final int i = -999999; //값변경 불가
}


abstract class AbstractClassExam{ // 상속가능 생성불가
    abstract String abstractMethodExam(int i,String s);    //body 없음, 재정의 위해 만든다.
    final int finalMethodExam(int i, int j){ //재정의 불가
        return i+j;
    }
}
////////////////////////////////////////////////

class Sample01 extends AbstractClassExam{ // 
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
//	//int finalMethodExam(int i, int j){ // 재정의 불가 
//		//return i*j;
//	}
//	
}

//class Sample02 extends FinalClassExam{  } // Final 클래스는 상속 불가함


 
abstract class Sample03 extends AbstractClassExam{
	 
//	String abstractMethodExam(int i ,String s){ 
//		return s+i;
//	 }
//	abstract String abstractMethodExam(String s,int i);   

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
//		AbstractClassExam ace = new AbstractClassExam(); // 생성 불가
		FinalClassExam fce = new FinalClassExam();
		//fce.i=100000;//값변경 불가
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}

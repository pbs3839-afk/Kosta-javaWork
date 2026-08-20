package ex0813.Lamda;

public class MainApp {
    public static void main(String[] args) {
        //1. 기존 방식
        AInterface aInterface1 = new Test();
        aInterface1.aa();

        //2. 익명의 이너 클래스(AnonymousInnerClass) 타입으로 작성
        AInterface aInterface2 = new AInterface() {
            @Override
            public void aa() {
                System.out.println("익명의 이너클래스 a호출");
            }
        }; //interface end

        aInterface2.aa();

        //3.람다식
        //반드시 interface 안에 메서드가 한 개 있을 경우에 사용 가능하다

        //********인수가 없는 경우**********//
        AInterface aInterface3 = () -> {};
        //********기능이 한 문장인 경우*******//
        AInterface aInterface4 = () -> {
            System.out.println("인수가 없는 람다식");
        };

        BInterface bInterface = (a) -> {
            System.out.println(a + "가 전달된 람다식");
        };
        bInterface.bb(5);

        CInterface cInterface = (a,b) -> a+b;
        int result = cInterface.cc(5,8);
        System.out.println("결과는 " + result);

    }
}

class Test implements AInterface{
    @Override
    public void aa() {
        System.out.println("Test의 aa 메서드 입니다.");
    }
}

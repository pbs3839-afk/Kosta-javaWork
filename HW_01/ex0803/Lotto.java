package ex0803;

import java.util.Arrays;
import java.util.Random;

public class Lotto {

    //랜덤 객체
    Random random = new Random();

    int [] lottos = new int[6];

    //0.로또 번호 생성
    public void makeLotto(){

        int count = 0;

        while(count < 6){

            int lottoNumber =  random.nextInt(45) + 1; //0부터 44까지의 정수인데, +1 하면 1부터 45까지의 정수
            if(inputArray(count,lottoNumber)){ //[1] 값 삽임 매서드 실행 //true이다 == 값이 중복이 아니고, 배열에 삽입됐다
                count++; //false이면 count 증가x
            }
        }

    }

    //1. 중복 체크하는 메서드
    private boolean check(int count, int lottoNumber){

        for(int i = 0; i < count; i++){ //6번을 다 도는게 아니라, 생성된 배열의 길이(count)만큼만 반복
            if(lottos[i] == lottoNumber){ //[3] 만약 이미 값이 배열에 있다면 false 반환
                return false;
            }
        }
        return true;
    }

    //2. 숫자 6개를 배열에 저장하는 메서드
    private boolean inputArray(int count, int lottoNumber){

        if(check(count,lottoNumber)){ //[2] 중복 체크 메서드 실행 //true이면 == 배열에 생성한 숫자가 없다면
            lottos[count] = lottoNumber; //배열에 삽입하고 true 반환
            return true;
        }
        return false;
    }

    //3. 배열을 내림차순으로 정렬하는 메서드
    public void sort(int[] lottos){

        int temp = 0;

        //버블 정렬(인접한 두개의 값을 비교)
        for(int i = 0; i < lottos.length-1; i++){
            for(int j = 0; j < lottos.length-1-i; j++){
                if(lottos[j] < lottos[j+1]){
                    temp = lottos[j];
                    lottos[j] = lottos[j+1];
                    lottos[j+1] = temp;
                }
            }
        }
    }

    //4. 배열의 값을 화면에 출력하는 메서드
    public void printResult(int[] lottos){
        System.out.println(Arrays.toString(lottos));
    }

    public static void main(String[] args) {

        Lotto lotto = new Lotto();

        System.out.println("랜덤한 6개 숫자를 생성합니다.");
        lotto.makeLotto();
        System.out.println("생성된 숫자 6개를 정렬합니다.");
        lotto.sort(lotto.lottos);
        System.out.print("오늘의 로또 숫자는 : ");
        lotto.printResult(lotto.lottos);

    }
}
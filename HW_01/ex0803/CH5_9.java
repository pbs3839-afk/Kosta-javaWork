package ex0803;

import java.util.Arrays;
import java.util.Scanner;

public class CH5_9 {

    Scanner sc = new Scanner(System.in);

    int[] scores = new int[]{};

    //초기화 함수
    public void makeScoreArray(int count) {
        scores = new int[count];
    }

    //점수 입력 함수
    public void inputScore(){

        for(int i=0; i<scores.length; i++){
            System.out.print("입력: ");
            scores[i] = sc.nextInt();
        }
    }

    //출력 함수
    public void listScore(){
        for(int i = 0; i<scores.length; i++){
            System.out.println("scores[i]:" + scores[i]);
        }
    }

    //분석
    public void calculateScore(){

        double avg = 0;

        //최고 점수
        Arrays.sort(scores);
        System.out.println("최고점수: "+ scores[scores.length-1]);

        //평균 구하기
        for(int i =0; i<scores.length; i++){
            avg += scores[i];
        }
        System.out.println("평균점수: "+ avg/scores.length);


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CH5_9 number9 = new CH5_9();

        boolean run = true;


        while (run){

            System.out.println("------------------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수 입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("------------------------------------------------------------");

            int select = sc.nextInt();

            System.out.println("선택 > " + select);

            switch (select){
                case 1 -> {
                    System.out.print("학생수 > ");
                    int count = sc.nextInt();
                    number9.makeScoreArray(count);
                }
                case 2 -> {
                    number9.inputScore();
                }
                case 3 -> {
                    number9.listScore();
                }
                case 4 -> {
                    number9.calculateScore();
                }
                case 5 -> {
                    run = false;

                }default -> {
                    System.out.println("다시 선택해주세요");
                }
            }

        }

    }
}
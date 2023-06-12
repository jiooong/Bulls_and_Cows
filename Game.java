import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // 게임 횟수 체크
        int cnt = 1;

        // 컴퓨터가 생성한 숫자
        String answer = makeRandomNum();

        // 게임 성공할 때까지 무한반복
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        while(true) {
            String result = "";
            int ball = 0;
            int strike = 0;

            System.out.printf("%d번째 시도: ", cnt++);
            // 사용자에게 숫자 3자리 입력받기
            Scanner sc = new Scanner(System.in);
            String s = sc.next();

            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(answer.charAt(i) == s.charAt(j)) {
                        if(i == j) {
                            strike++;
                        }
                        else {
                            ball++;
                        }
                    }
                }
            }

            System.out.println(ball + "B" + strike + "S");
            if(strike == 3) {
                System.out.printf("%d번만에 맞히셨습니다.\n", cnt-1);
                System.out.println("게임을 종료합니다.");
                break;
            }


        }


    }

    private static String makeRandomNum() {
        Random random = new Random(System.currentTimeMillis());
        double d = Math.random();
        ArrayList<Integer> arr = new ArrayList<>();
        while(arr.size() != 3) {
            int rand = random.nextInt(10);
            if(!arr.contains(rand)) {
                arr.add(rand);
            }
        }

        String s = "";
        for(int i: arr) s += String.valueOf(i);

        return s;
    }

}

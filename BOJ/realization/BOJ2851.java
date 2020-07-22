import javax.net.ssl.SSLContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ2851 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int cal1 = 0;
        int cal2 = 0;
        int score = 0;


        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
            score += array[i];
            if (score >= 100) {     //score가 기준인 100을 넘는다면 종료시킴
                cal1 = score;
                break;
            }
            cal2 = score;   //100을 넘지 못할 때의 최대값이 cal2가 된다.
        }
        if (cal1 == cal2)   //같다면 더 큰숫자를 출력(cal1)
            System.out.print(cal1);
        else {          // 100과 차이가 더 적은 숫자를 판별해서 출력
            System.out.print(cal1 - 100 < 100 - cal2 ? cal1 : cal2);
        }
    }
}

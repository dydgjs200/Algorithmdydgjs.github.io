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
            if (score >= 100) {
                cal1 = score;
                break;
            }
            cal2 = score;
        }
        if (cal1 == cal2)
            System.out.print(cal1);
        else {
            System.out.print(cal1 - 100 < 100 - cal2 ? cal1 : cal2);
        }
    }
}
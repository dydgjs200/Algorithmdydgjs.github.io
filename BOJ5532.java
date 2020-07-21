import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class BOJ5532 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        int count1 = A/C;
        int count2 = B/D;
        int result = L - (count1 > count2 ? count1+1 : count2+1);   //+1을 해주는 이유는 나머지가 존재하므로
        System.out.print(result);
    }
}
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

        int count1=A/C;
        int count2=B/D;
        if(A%C!=0)  //나머지가 있을 경우 +1
            count1++;
        if(B%D!=0)
            count2++;
        int result = count1<count2 ?count2:count1;
        System.out.print(L-result);
    }
}

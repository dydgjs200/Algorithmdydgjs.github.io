import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ1159 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] alpha = new int[127];

        for(int i=0; i<n; i++){
            char c = scanner.next().charAt(0);
            alpha[c]++;
        }

        String s = "";
        for(int i='a'; i<'z'; i++){
            if(alpha[i] >= 5)
                s += (char)alpha[i];
        }
        if(s.length() == 0)
            System.out.print("PREDAJA");
    }
}
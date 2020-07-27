import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ14501 {

    static int[] t;
    static int[] p;
    static int max = 0;
    static int n;

    static void dfs(int sum, int index){
        if(index >= n){
            if(max < sum)
                max = sum;
            return;
        }
        if(index+t[index] <= n) //상담한다.
            dfs(sum+p[index],index+t[index]);
        if(index+1<=n)  //상담하지 않는다.
            dfs(sum,index+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        t = new int[n];
        p = new int[n];

        for(int i=0; i<t.length; i++){
            t[i] = scanner.nextInt();
            p[i] = scanner.nextInt();
        }

        dfs(0,0);
        System.out.print(max);
    }
}
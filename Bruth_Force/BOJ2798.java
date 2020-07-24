import javax.net.ssl.SSLContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ2798 {

    static int result = 0;
    static int m =0;
    static void pick(int[] array, int cnt, int sum, int index){
        if(index >= array.length || cnt > 3 || sum > m)
            return;
        if(cnt == 3 && result < sum){
            result = sum;
            return;
        }
        pick(array,cnt+1,sum+array[index],index+1);
        pick(array,cnt,sum,index+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        m = scanner.nextInt();
        int[] card = new int[n];

        for(int i=0; i<n; i++){
            card[i] = scanner.nextInt();
        }

        pick(card,0,0,0);
        System.out.print(result);
    }
}

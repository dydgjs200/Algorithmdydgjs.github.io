import javax.net.ssl.SSLContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ2798 {
    static int score = 0;
    static void pick(int[] array, int index, int result, int cnt){
        if(cnt == 3 && result <= score){
            score = Math.max(result,score);
            return;
        }
        if(index >= array.length || cnt > 3 || result > score)
            return;

        pick(array,index+1,result+array[index],cnt+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        score = scanner.nextInt();
        int[] card = new int[10];

        for(int i=0; i<n; i++){
            card[i] = scanner.nextInt();
        }

        pick(card,0,0,0);
        System.out.print(score);
    }
}
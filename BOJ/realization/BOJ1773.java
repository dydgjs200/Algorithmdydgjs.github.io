import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ1773 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max_sec = scanner.nextInt();
        int[] array = new int[n];
        int[] count = new int[max_sec+1];   //count 배열에 공배수들을 카운트해서 중복된다면 해당 count[index]가 증가한다.

        for(int i=0; i<array.length; i++){
            array[i] = scanner.nextInt();
            int pos = 1;
            while(array[i]*pos <= max_sec){
                count[array[i]*pos]++;
                pos++;
            }
        }

        int to = 0;
        for(int i=0; i<count.length; i++){
            if(count[i] >= 1)       //한번 이상 나왔다면 중복된 것으로 1번만 횟수를 계산함.
                to++;
        }
        System.out.print(to);
    }
}
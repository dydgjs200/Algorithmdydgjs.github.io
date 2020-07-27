import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ2309 {
    static int[] array = new int[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noA = 0;
        int noB = 0;

        int sum = 0;
        for(int i=0; i<9; i++){
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum - array[i] - array[j] == 100){
                    noA = array[i];
                    noB = array[j];
                    break;
                }
            }
        }

        Arrays.sort(array);

        for(int i=0; i<9; i++){
            if(array[i] == noA || array[i] == noB)
                continue;
            System.out.println(array[i]);
        }
    }
}
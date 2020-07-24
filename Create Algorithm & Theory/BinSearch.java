import javax.net.ssl.SSLContext;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BinSearch {

    static int Bin_search(int[] array, int n, int find){
        int start = 0;
        int end = n-1;

        do{
            int mid = (start+end)/2;
            if(find == array[mid])
                return mid;
            else if(array[mid] < find)
                start = mid+1;
            else
                end = mid-1;
        }while(start <= end);
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int find_num = scanner.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] =scanner.nextInt();
        }
        int[] map = array.clone();
        Arrays.sort(array);

        int res = Bin_search(array,n,find_num);
        if(res == -1)
            System.out.print("없음");
        else{
            for(int i=0; i<array.length; i++){
                if(array[res] == map[i]) {
                    System.out.print(i + "인덱스에 위치");
                    break;
                }
            }
        }

    }
}
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ1475 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int[] count = new int[127]; //number ascii 48~57
        int max = 0;
        int max2 = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '6' || s.charAt(i) == '9')
                count[57]++;    //6과 9를 같게 취급하고 9의 아스키코드인 57에 넣음
            else
                count[s.charAt(i)]++;
        }

        for(int i=48; i<58; i++){
            if(i == 57) {
                if(count[57] % 2 != 0)
                    max2 = count[57] / 2 + 1;   //나머지가 있으면 한세트 추가
                else
                    max2 = count[57] / 2;
            }
            else {
                if (max < count[i])
                    max = count[i];
            }
        }
        System.out.println(max < max2 ? max2 : max);
    }
}
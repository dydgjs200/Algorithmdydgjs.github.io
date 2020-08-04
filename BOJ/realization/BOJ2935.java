import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ2935 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String A = scanner.nextLine();
        String cal = scanner.nextLine();
        String B = scanner.nextLine();

        if(A.length() < B.length()){    //만약 b가 더 크면 a와 b를 바꿔서 a가 더 크게만듦.
            String tmp = A;
            A = B;
            B = tmp;
        }

        if(cal.equals("*")){
            for(int i=0; i<B.length()-1; i++){
                A += "0";
            }
            System.out.print(A);
        }
        else if(cal.equals("+")){
            if(A.length() == B.length()){   //a,b가 같다면 맨 앞자리는 2가 된다.
                A = A.replace("1","2");
                System.out.print(A);
            }
            else{   //A가 더 큰 수라면
                String[] sp = A.split("");
                sp[A.length()-B.length()] = "1";
                for(int i=0; i<sp.length; i++){
                    System.out.print(sp[i]);
                }
            }
        }
    }
}
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class BOJ9012 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++){
            Stack<String> stack = new Stack<>();
            String s = scanner.next();
            String[] sp = s.split("");

            if(s.length()%2 != 0) //만약 문자열이 짝수가 아니면 무조건 no
                System.out.println("NO");
            else{
                boolean res = true;
                for(int j=0; j<s.length(); j++){
                    if(s.charAt(j) == '(')
                        stack.push("(");
                    else{
                        if(stack.isEmpty()){
                            res = false;
                            break;
                        }
                        else
                            stack.pop();
                    }
                }
                if(stack.isEmpty() && res)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
}
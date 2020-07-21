import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static int number_system = 0;
    //기수변환은 target이 되는 숫자를 number_system으로 나눌 때의 나머지를 역순으로 출력해야함.
    static Stack<Integer> stack = new Stack<Integer>(); //후입선출을 이용함.
    static void cal(int n, int ns){
        if(n < ns) {        //ns는 변환하려는 진수로 마지막 계산 시에 나머지는 n이 된다.
            stack.push(n);
            return;
        }
        else {
            stack.push(n % ns);
            cal(n / ns, ns);        //재귀를 통해 계산된 나머지를 호출
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        number_system = scanner.nextInt();

        cal(num,number_system);

        while(!stack.isEmpty()){
            if(number_system == 16){    //16진수로 변환할 때
                String[] s = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
                int r = Integer.valueOf(stack.pop());       //stack의 값에 대응하는 인덱스를 구해서 출력
                System.out.print(s[r]);
            }
            else        //2,8진수일 때
                System.out.print(stack.pop());
        }

    }
}
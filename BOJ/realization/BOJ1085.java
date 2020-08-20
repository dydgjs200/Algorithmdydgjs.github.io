import java.util.*;

public class BOJ1085 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int m_h = Math.min(h-y,x);  //x좌표와 직사각형에서 x좌표 뺀 값을 비교해야함.
        int m_w = Math.min(w-x,y);
        System.out.print(Math.min(m_h,m_w));    //위의 식을 통해 X와 Y중 더 작은 숫자를 찾는다.
    }
}
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;

public class find_string {

    /*문자열을 찾는 알고리즘. 완전탐색으로 구현하였으며 n^2 의 시간이 소모된다. 찾을경우 find!를 출력하며 아닐경우 아무것도 출력하지 않는다*/

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String target = "abcdefasg";
        String find = "efa";
        boolean res = true;
        int result = 0;

        for(int i=0; i<target.length(); i++){
            if(target.charAt(i) == find.charAt(0)){
                int pos1 = i;   //pos1은 타겟에
                int pos2 = 0;   //pos2는 find에 대입
                while(res){
                    if(pos1 < target.length() && pos2 < find.length()){
                        if(target.charAt(pos1) != find.charAt(pos2))
                            res = false;
                        else {
                            pos1++;
                            pos2++;
                            if(pos2 >= find.length()) {  //찾는 인덱스가 끝에 도달하면 result=1
                                result = 1;
                                res = false;
                            }
                        }
                    }
                }
            }
            if(result == 1){
                System.out.print("find!");
                break;
            }
        }

    }
}

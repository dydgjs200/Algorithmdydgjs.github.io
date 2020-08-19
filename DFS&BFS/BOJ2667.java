import java.util.*;

public class BOJ2667 {

    static int[][] map;
    static boolean[][] visit;
    static int[] move_x = {1,-1,0,0};
    static int[] move_y = {0,0,-1,1};
    static int address,n;
    static int[] result = new int[1000];        //cnt에 대한 값을 배열에 저장

    static int bfs(int x, int y){   //int형으로 각 address의 카운트를 반환
        Queue<Point> que = new LinkedList<>();
        int cnt = 1;
        visit[x][y] = true;
        que.add(new Point(x,y));

        while(!que.isEmpty()){
            Point p = que.poll();

            for(int i=0; i<4; i++){
                int mx = p.x+move_x[i];
                int my = p.y+move_y[i];

                if(mx >= 0 && my >= 0 && mx < n && my < n){ //범위를 벗어나지 않으며
                    if(!visit[mx][my] && map[mx][my] == 1){ //이동하려는 방향이 범위 내라면
                       que.add(new Point(mx,my));
                       visit[mx][my] = true;
                       cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = scanner.next();
            for(int j=0; j<s.length(); j++){
                map[i][j] = s.charAt(j) - '0';  //한 줄의 내용을 한글자씩 불러온다.
            }
        }   //배열 생성

        int pos = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j] && map[i][j] != 0){
                    address++;  //address는 0이 아닌 첫 수의 경우 +1을 해준다.
                    result[pos] = bfs(i,j); //result[pos]에 저장한 뒤 인덱스를 늘려준다.
                    pos++;
                }
            }
        }
        System.out.println(address);

        Arrays.sort(result);    //카운트 배열 오름차순 정리

        for(int i=0; i<result.length; i++){
            if(result[i] != 0)  //0이 아닌 경우만 출력
                System.out.println(result[i]);
        }


    }
}
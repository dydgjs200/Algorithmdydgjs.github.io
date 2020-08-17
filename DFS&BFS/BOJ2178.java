import java.util.*;

public class BOJ2178 {
    static int n,m,cnt;
    static int[][] array;
    static boolean[][] visit;
    static int[] move_x = {1,-1,0,0};
    static int[] move_y = {0,0,-1,1};

    static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();      //큐에 좌표를 찍는 point 클래스를 적용
        visit[x][y] = true;
        que.add(new Point(x,y));

        while(!que.isEmpty()){
            Point p = que.poll();

            for(int i=0; i<4; i++){
                int mx = p.x+move_x[i]; //Point p에 대한 x좌표
                int my = p.y+move_y[i];

                if(mx >= 0 && my >= 0 && mx < n && my <m){
                    if(array[mx][my] == 1 && !visit[mx][my]){
                        que.add(new Point(mx,my));
                        array[mx][my] = array[p.x][p.y]+1;
                        visit[mx][my] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        array = new int[n][m];
        visit = new boolean[n][m];


        for(int i=0; i<n; i++){
            String s = scanner.next();
            for(int j=0; j<s.length(); j++){
               if(s.charAt(j) == '0')
                    array[i][j] = 0;
                else
                    array[i][j] = 1;
            }
        }

        bfs(0,0);
        System.out.print(array[n-1][m-1]);
    }
}
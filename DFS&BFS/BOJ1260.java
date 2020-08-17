import java.util.*;

public class BOJ1260 {
    static int n,m,v;
    static int[][] array;
    static boolean[] visit;
    static Stack<Integer> stack = new Stack<>();

    static void dfs(int node){  //재귀사용
        visit[node] = true;
        stack.push(node);
        System.out.print(node + " ");

        for(int i=1; i<=n; i++){
            if(array[node][i] == 1 && visit[i] == false){
                stack.pop();
                dfs(i);
            }
        }
    }

    static void bfs(int node){
        Queue<Integer> que = new LinkedList<>();
        que.offer(node);
        visit[node] = true;
        System.out.print(node + " ");

        while(!que.isEmpty()){
            int c = que.poll();

            for(int i=1; i<=n; i++){
                if(array[c][i] == 1 && visit[i] == false){
                    que.offer(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        v = scanner.nextInt();

        array = new int[n+1][n+1];
        visit = new boolean[n+1];

        for(int i=0; i<m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            array[a][b] = array[b][a] = 1;
        }

        dfs(v);

        visit = new boolean[n+1];
        System.out.println();

        bfs(v);
    }
}
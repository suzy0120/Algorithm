import java.util.Scanner;
 
public class Solution {
     
    static int N;
    static int M;
    static boolean[] visited;
    static int[][] adjArr;
    static int max;
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            M = sc.nextInt();
            visited = new boolean[N+1];
            adjArr = new int[N+1][N+1]; // 인접 행렬
             
            for(int i = 0; i < M; i++) {
                int x = sc.nextInt(); // 시작 정점
                int y = sc.nextInt(); // 끝 정점
                 
                adjArr[x][y] = adjArr[y][x] = 1;
            }
             
            max = 0;
            for(int i = 1; i < N+1; i++) {
                visited[i] = true;
                DFS(i, 1);
                visited[i] = false;
            }
            System.out.println("#" + tc + " " + max);
        }
    }
     
    // 재귀
    public static void DFS(int n, int node) {
        max = Math.max(max, node);
         
        for(int i = 1; i < N+1; i++) {
            if(!visited[i] && adjArr[n][i] == 1) {
                visited[i] = true;
                DFS(i, node+1);
                visited[i] = false;
            }
        }
    }
}
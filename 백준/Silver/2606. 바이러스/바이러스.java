import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N; // 정점 수
    public static int M; // 간선 수
    public static int count = -1;
    public static int[][] adjArr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        adjArr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt(); // 시작 정점
            int B = sc.nextInt(); // 끝 정점
            adjArr[A][B] = adjArr[B][A] = 1;
        }

        DFS(1);
        if(count == -1) {
        	count = 0;
        }
        System.out.println(count);
    }

    // 인자로 현재 내가 방문하고 있는 정점이 들어온다.
    public static void DFS(int v) {
		// v에 대한 방문처리를 하겠다.
    	count++;
    	visited[v] = true;
        // 방문하지 않았으면서, 너와 내가 연결된 간선이 존재한다면 재귀호출
        for (int i = 0; i < N+1; i++) {
            if (!visited[i] && adjArr[v][i] == 1)
            	DFS(i);
        }
    }
}
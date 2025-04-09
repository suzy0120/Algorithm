import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N; // 정점 수
    public static int[][] adjArr;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt(); // 간선 수
        int V = sc.nextInt(); // 시작할 정점의 번호
        
        adjArr = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            int A = sc.nextInt(); // 시작 정점
            int B = sc.nextInt(); // 끝 정점
            adjArr[A][B] = adjArr[B][A] = 1;
        }

        visited = new boolean[N+1];
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];
        BFS(V);
    }

    // 인자로 현재 내가 방문하고 있는 정점이 들어온다.
    public static void DFS(int v) {
		// v에 대한 방문처리를 하겠다.
    	visited[v] = true;
        System.out.print(v + " ");
        //방문하지 않았으면서, 너와 내가 연결된 간선이 존재한다면 재귀호출
        for(int i = 0; i < N+1; i++) {
            if(!visited[i] && adjArr[v][i] == 1)
            	DFS(i);
        }
    }
    
    // 인자로 현재 내가 방문하고 있는 정점이 들어온다.
    public static void BFS(int v) {
		// 시작정점을 큐에 넣는다.
		queue.add(v);
		visited[v] = true; // 방문처리를 한다.
		// 큐가 공백이 될때까지 반복문 수행
		// 큐가 공백이 아니라면 반복문 수행
		while(!queue.isEmpty()) {
			// 정점을 하나 꺼내자
			int n = queue.poll();
			System.out.print(n + " ");
			// 나와 연결되어 있으면서 방문하지 않은 친구들은 Q에 넣고 방문처리를 한다.
			for(int i = 1; i < N+1; i++) {
				if(!visited[i] && adjArr[n][i] == 1) {
					queue.add(i); // 큐에 넣고 방문처리
					visited[i] = true;
				}
			}
		}
	}
}
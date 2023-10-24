import java.util.Scanner;

public class Main {
	public static int n, end;
	public static int answer = 0;
	public static int[][] family;
	public static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 전체 사람의 수
		// 촌수를 계산해야 하는 서로 다른 두 사람의 번호
		int srt = sc.nextInt();
		end = sc.nextInt();
		int m = sc.nextInt(); // 부모 자식들 간의 관계의 개수
		
		family = new int[n+1][n+1];
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt(); // 부모
			int y = sc.nextInt(); // 자식
			family[x][y] = 1;
			family[y][x] = 1;
		}
		
		visit = new boolean[n+1];
		DFS(srt, 0);
		System.out.println(answer == 0 ? -1 : answer);
	}
	
	public static void DFS(int v, int count) {
		visit[v] = true;
		if(v == end) {
			answer = count;
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visit[i] && family[v][i] == 1) { // 방문하지 않았고 간선이 있다면
				DFS(i, count+1);
			}
		}
	}
}
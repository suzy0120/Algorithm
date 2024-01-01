import java.util.Scanner;

public class Main {
	public static int[] dr = {1, 1, 1};
	public static int[] dc = {-1, 0, 1};
	public static int N, M;
	public static int[][] root;
	public static boolean[][] visit;
	public static int min = Integer.MAX_VALUE;
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		root = new int[N][M];
		visit = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				root[r][c] = sc.nextInt();
			}
		}
		
		for(int c = 0; c < M; c++) {
            visit[0][c] = true;
            DFS(0, c, -1, root[0][c]); // -1은 이전 방향이 없음을 나타냄
            visit[0][c] = false;
        }
		
		System.out.println(min);
	}
	
	public static void DFS(int r, int c, int prevDir, int money) {
		if(r == N-1) {
			min = Math.min(min, money);
			return;
		}
		
		for(int d = 0; d < 3; d++) {
			if(d == prevDir) continue; // 같은 방향으로는 이동하지 않음
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!(0 <= nr && nr < N && 0 <= nc && nc < M) || visit[nr][nc]) continue;
			visit[nr][nc] = true;
            DFS(nr, nc, d, money + root[nr][nc]);
            visit[nr][nc] = false;
		}
	}
}
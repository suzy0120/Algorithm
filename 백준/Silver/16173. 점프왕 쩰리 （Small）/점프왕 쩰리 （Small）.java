import java.util.Scanner;

public class Main {
	public static int[] dr = {0, 1};
	public static int[] dc = {1, 0};
	public static int N;
	public static int[][] game;
	public static boolean[][] visit;
	public static String result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		game = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				game[r][c] = sc.nextInt();
			}
		}
		
		result = "Hing";
		visit = new boolean[N][N];
		visit[0][0] = true;
		DFS(0, 0);
		
		System.out.println(result);
	}

	public static void DFS(int r, int c) {
		if(game[r][c] == -1) {
			result = "HaruHaru";
			return;
		}
		
		for(int d = 0; d < 2; d++) {
			int nr = r + dr[d] * game[r][c];
			int nc = c + dc[d] * game[r][c];

			if((0 <= nr && 0 <= nc && nr < N && nc < N) && !visit[nr][nc]) {
				visit[nr][nc] = true;
				DFS(nr, nc);
			}
		}
	}
}
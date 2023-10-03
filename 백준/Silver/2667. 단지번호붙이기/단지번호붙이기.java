import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	// 우 하 좌 상 탐색
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N, sum;
	static int[][] apart;
	static boolean[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		apart = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			char[] cArr = sc.next().toCharArray();
			for(int c = 0; c < N; c++) {
				apart[r][c] = cArr[c] - '0';
			}
		}
		
		int total = 0;
		visit = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<>();
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(visit[r][c] || apart[r][c] == 0) continue;
				visit[r][c] = true;
				sum = 1;
				DFS(r, c);
				total++;
				list.add(sum);
			}
		}
		
		list.sort(Comparator.naturalOrder());
		System.out.println(total);
		for(int n : list) {
			System.out.println(n);
		}
	}
	
	public static void DFS(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!(0 <= nr && 0 <= nc && nr < N && nc < N) || visit[nr][nc] || apart[nr][nc] == 0) continue;
			visit[nr][nc] = true;
			sum++;
			DFS(nr, nc);
		}
	}
}
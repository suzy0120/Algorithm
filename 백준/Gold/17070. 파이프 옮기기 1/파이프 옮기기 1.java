import java.util.Scanner;

public class Main {
	// 오른쪽, 오른쪽 아래 대각선, 아래 방향
	public static int[] dr = {0, 1, 1};
	public static int[] dc = {1, 1, 0};
	public static int N;
	public static int[][] house;
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		house = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				house[r][c] = sc.nextInt();
			}
		}
		
		DFS(0, 1, 0);
		System.out.println(count);
	}
	
	public static void DFS(int r, int c, int dir) {
		if(r == (N-1) && c == (N-1)) { // 파이프의 한쪽 끝이 (N, N)에 도착
			count++;
		}
		
		// 놓여져 있는 파이프의 방향 알아내기
		int start = dir - 1; 
		int end = dir + 1;
		if(start < 0) {
			start = 0;
		}
		if(end >= 3) {
			end = 2;
		}
		
		for(int d = start; d <= end; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!(nr < N && nc < N) || house[nr][nc] == 1) continue; // 범위를 벗어나거나 벽이 있다면 넘어간다.
			if(d == 1) { // 대각선 방향으로 가기 전 오른쪽, 아래, 오른쪽 아래 대각선 방향이 빈 칸인지 확인
				if(house[r+dr[0]][c+dc[0]] == 1 || house[r+dr[2]][c+dc[2]] == 1) continue;
			}
			DFS(nr, nc, d);
		}
	}
}
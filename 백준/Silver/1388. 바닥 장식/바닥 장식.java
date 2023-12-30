import java.util.Scanner;

public class Main {
	public static int N, M;
	public static char[][] tile;
	public static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 세로 크기
		M = sc.nextInt(); // 가로 크기
		tile = new char[N][M];
		visit = new boolean[N][M];
		
		// 바닥 장식 모양 입력 받기
		for(int r = 0; r < N; r++) {
			String s = sc.next();
			for(int c = 0; c < M; c++) {
				tile[r][c] = s.charAt(c);
			}
		}
		
		int count = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(visit[r][c]) continue;
				if(tile[r][c] == '-') { // 가로 타일 탐색
					DFS(r, c, true);
				} else {
					DFS(r, c, false); // 새로 타일 탐색
				}
				count++; // 새로운 바닥 장식
			}
		}
		
		System.out.println(count);
	}

	public static void DFS(int r, int c, boolean row) {
		visit[r][c] = true;
		if(row) { // 현재 타일이 가로 방향이라면, 같은 행에서 다음 열의 타일을 탐색
			c++;
			if(c < M && tile[r][c] == '-') DFS(r, c, true);
		} else { // 현재 타일이 세로 방향이라면, 같은 열에서 다음 행의 타일을 탐색
			r++;
			if(r < N && tile[r][c] == '|') DFS(r, c, false);
		}
	}
}
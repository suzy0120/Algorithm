import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	public static int N, M;
	public static int[][] baechu;
	public static boolean[][] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		
		for(int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); // 배추밭의 가로길이
			N = sc.nextInt(); // 배추밭의 세로길이
			int K = sc.nextInt(); // 배추가 심어져 있는 위치의 개수
			
			baechu = new int[N][M];
			for(int i = 1; i <= K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				baechu[Y][X] = 1; // 배추 심기
			}
			
			visit = new boolean[N][M];
			int count = 0;
			// 배추밭 탐색 시작 ~
			for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visit[r][c] && baechu[r][c] == 1) {
                        visit[r][c] = true; // 방문 처리
            			BFS(r, c);
            			count++; // 배추들이 모여있는 곳 탐색 끝 = 배추흰지렁이 한마리 필요
                    }
                }
            }
			
			System.out.println(count);
		}
	}

	public static void BFS(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c}); // 시작 정점을 큐에 넣기
		
		while(!queue.isEmpty()) { // 큐가 공백이 될때까지 반복문 수행
			Integer[] rc = queue.poll(); // 정점을 하나 꺼내자
			r = rc[0];
			c = rc[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				// 범위를 벗어나거나 배추가 심어져 있지 않거나 이미 방문했다면 넘어가자
				if(!(0 <= nr && nr < N && 0 <= nc && nc < M) || baechu[nr][nc] == 0 || visit[nr][nc]) continue;
				visit[nr][nc] = true; // 방문 처리
				queue.add(new Integer[] {nr, nc}); // 큐에 넣기
			}
		}
	}
}
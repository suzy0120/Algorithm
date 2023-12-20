import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	public static int N, M;
	public static int[][] water;
	public static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		water = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				water[i][j] = sc.nextInt();
			}
		}
		
		BFS();
		
		int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
            	count = Math.max(count, water[i][j]);
            }
        }
		
		System.out.println(count-1);
	}
	
	public static void BFS() {
		Queue<Integer[]> queue = new LinkedList<>();
		
        // 상어의 위치를 찾아 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (water[i][j] == 1) {
                    queue.add(new Integer[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
		
		while(!queue.isEmpty()) {
			Integer[] rc = queue.poll();
			int r = rc[0];
			int c = rc[1];
			
			for(int d = 0; d < 8; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!(0 <= nr && nr < N && 0 <= nc && nc < M) || visit[nr][nc]) continue;
				water[nr][nc] = water[r][c] + 1;
                visit[nr][nc] = true;
				queue.add(new Integer[] {nr, nc});
			}
		}
	}
}
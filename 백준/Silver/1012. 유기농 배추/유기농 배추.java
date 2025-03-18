import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	public static int N, M;
	public static int[][] baechu;
	public static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			baechu = new int[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				baechu[Y][X] = 1;
			}
			
			visit = new boolean[N][M];
			int count = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(!visit[r][c] && baechu[r][c]==1) {
						visit[r][c] = true;
						BFS(r, c);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void BFS(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		
		while(!queue.isEmpty()) {
			Integer[] rc = queue.poll();
			r = rc[0];
			c = rc[1];
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(!(0<=nr && nr<N && 0<=nc && nc<M) || baechu[nr][nc]==0 || visit[nr][nc]) continue;
				
				visit[nr][nc] = true;
				queue.add(new Integer[] {nr, nc});
			}
		}
	}
}

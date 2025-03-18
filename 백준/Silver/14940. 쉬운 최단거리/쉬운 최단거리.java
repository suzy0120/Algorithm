import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static int[] dr = {0, 1, 0, -1};
	public static int[] dc = {1, 0, -1, 0};
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visit;
	public static int[][] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[N][M];
		answer = new int[N][M];
        
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c]==2) {
					visit[r][c] = true;
					answer[r][c] = 0;
					BFS(r, c);
				}
				
				if(map[r][c] == 0) {
					visit[r][c] = true;
					answer[r][c] = 0;
				}
			}
		}
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
		        if(map[r][c]==1 && !visit[r][c]) {
		            answer[r][c] = -1;
		        }
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				sb.append(answer[r][c]).append(" ");
			}
			sb.append("\n");
		}
        
		System.out.println(sb.toString());
	}
	
	public static void BFS(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {r, c});
		
		while(!queue.isEmpty()) {
			Integer[] rc = queue.poll();
			int cr = rc[0];
			int cc = rc[1];
			
			for(int d=0; d<4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr<0 || N<=nr || nc<0 || M<=nc) continue;
				if(map[nr][nc]==0 || visit[nr][nc]) continue;
				
				answer[nr][nc] = answer[cr][cc]+1;
				visit[nr][nc] = true;
				
				queue.add(new Integer[] {nr, nc});
			}
		}
	}
}

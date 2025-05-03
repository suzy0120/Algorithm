import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	public static int N, M;
	public static int[][] miro;
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		miro = new int[N][M];
		visited = new boolean[N][M];
		for(int r=0; r<N; r++) {
			String line = br.readLine();
			for(int c=0; c<M; c++) {
				miro[r][c] = line.charAt(c) - '0';
			}
		}
		
		System.out.println(BFS(0, 0));
	}
	
	public static int BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r, c, 1});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cnt = cur[2];
			
			if(cr == N-1 && cc == M-1) return cnt;
			
			for(int d=0; d<4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(miro[nr][nc]==0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc, cnt+1});
			}
		}
		
		return -1;
	}
}

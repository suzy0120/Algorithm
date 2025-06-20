import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		int[][] snail = new int[N][N];
		int[] dr = {1, 0, -1, 0}; // ↓ → ↑ ←
		int[] dc = {0, 1, 0, -1};
		
		int r = 0, c = 0, dir = 0;
		int row = 0, col = 0;
		for(int value=N*N; value>=1; value--) {
			snail[r][c] = value;
			
			if(snail[r][c] == num) {
				row = r+1;
				col = c+1;
			}
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr<0 || nc<0 || nr>=N || nc>=N || snail[nr][nc]!=0) {
				dir = (dir+1) % 4;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			
			r = nr;
			c = nc;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(row).append(" ").append(col);
		
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		int[][] snail = new int[N][N];
		int[] dx = {1, 0, -1, 0}; // ↓ → ↑ ←
		int[] dy = {0, 1, 0, -1};
		
		int x = 0, y = 0, dir = 0;
		for(int i=N*N; i>=1; i--) {
			snail[x][y] = i;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N || snail[nx][ny] != 0) {
				dir = (dir+1) % 4;
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			
			x = nx;
			y = ny;
		}
		
		int r=0, c=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(snail[i][j] == num) {
					r = i+1;
					c = j+1;
				}
				
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(r + " " + c);
	}
}

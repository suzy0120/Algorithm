import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sum = new int[N+1][M+1];
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=M; c++) {
				int val = Integer.parseInt(st.nextToken());
				sum[r][c] = sum[r][c-1] + sum[r-1][c] - sum[r-1][c-1] + val;
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<K; tc++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int result = sum[x][y] - sum[i-1][y] - sum[x][j-1] + sum[i-1][j-1];
			System.out.println(result);
		}
	}
}

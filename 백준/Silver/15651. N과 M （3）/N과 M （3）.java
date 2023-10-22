import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] nums, result;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		for(int i = 0; i < nums.length; i++) { // 1부터 N까지 자연수 담기
			nums[i] = i+1;
		}
		
		result = new int[M];
		perm(0);
		System.out.println(sb);
	}
	
	public static void perm(int idx) {
		if(idx == M) { // M개를 고른 수열			
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[idx] = nums[i];
			perm(idx+1);
		}
	}
}
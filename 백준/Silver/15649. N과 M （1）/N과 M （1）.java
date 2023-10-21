import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[] nums, result;
	public static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		for(int i = 0; i < nums.length; i++) { // 1부터 N까지 자연수 담기
			nums[i] = i+1;
		}
		
		result = new int[M];
		visit = new boolean[N];
		perm(0);
	}

	public static void perm(int idx) {
		if(idx == M) { // M개를 고른 수열
			for(int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i]) continue; // 이미 사용한 원소
			
			result[idx] = nums[i];
			visit[i] = true; // i번째 원소 사용 표시
			perm(idx+1);
			visit[i] = false; // i번째 원소 원상 복구
		}
	}
}
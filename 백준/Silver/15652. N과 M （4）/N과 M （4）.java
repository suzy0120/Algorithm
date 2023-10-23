import java.util.Scanner;

public class Main {
	public static int N, M;
	public static int[] nums, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		nums = new int[N];
		for(int i = 0; i < N; i++) { // 1부터 N까지 자연수 담기
			nums[i] = i+1;
		}
		
		result = new int[M];
		perm(0);
	}
	
	public static void perm(int idx) {
		if(idx == M) { // M개를 고른 수열
			for(int i = 0; i < M-1; i++) { // 범위를 'M'이 아닌 'M-1'까지 해줘야 인덱스 오류 x
				if(result[i] > result[i+1]) { // 전 값이 더 크면 그대로 return 해준다. 왜냐 ? 오름차순으로 출력해야 해서 이미 뽑혔기 때문.
					return;
				}
			}
			
			for(int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			result[idx] = nums[i];
			perm(idx+1);
		}
	}
}
import java.util.Scanner;

public class Main {
	public static int N, S;
	public static int[] arr;
	public static boolean[] sel;
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		sel = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		powerset(0);
		System.out.println(S == 0 ? count-1 : count);
	}
	
	// idx : 해당 위치 판단
	public static void powerset(int idx) {
		// 기저파트
		if (idx == N) { // 모든 원소를 다 판단했다. (넣을지 말지)
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += arr[i]; // 부분수열의 합 구하기
				}
			}
			if(sum == S) { // 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
				count++;
			}
			return;
		}
		// 재귀파트
		sel[idx] = false;
		powerset(idx + 1);

		sel[idx] = true;
		powerset(idx + 1);
	}
}
import java.util.Scanner;

public class Solution {
    
	public static int N;
	public static int K;
	public static int[] num;
	public static boolean[] sel;
	public static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			num = new int[N];
			for(int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			
			sel = new boolean[N];
			count = 0;
			System.out.println("#" + tc + " " + powerset(0));
		}
	}
	
	public static int powerset(int idx) {
		// 기저 부분
		if(idx == N) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				if(sel[i]) {
					sum += num[i];
				}
			}
			if(sum == K) {
				return count++;
			} else {
				return 0;
			}
		}
		
		sel[idx] = true;
		powerset(idx+1);
		sel[idx] = false;
		powerset(idx+1);
		return count;
	}
}
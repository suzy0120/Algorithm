import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			int[][] score = new int[N][2];
			for(int r = 0; r < N; r++) {
				score[r][0] = sc.nextInt();
				score[r][1] = sc.nextInt();
			}
			
			Boolean[] sel = new Boolean[N];
			int max = 0;
			System.out.println("#" + tc + " " + powerset(score, sel, N, L, 0, max));
		}
	}
	
	public static int powerset(int[][] score, Boolean[] sel, int N, int L, int idx, int max) {
		int tSum = 0;
		int cSum = 0;
		// 기저 부분
		if(idx == N) {
			for(int i = 0; i < N; i++) {
				if(sel[i]) {
					tSum += score[i][0];
					cSum += score[i][1];
				}
			}
			if(cSum <= L) return tSum;
			else return 0;
		}
		
		sel[idx] = true;
		max = Math.max(max, powerset(score, sel, N, L, idx+1, max));
		sel[idx] = false;
		max = Math.max(max, powerset(score, sel, N, L, idx+1, max));
		return max;
	}
}
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] narr = new int[N];
			for(int i = 0; i < N; i++) {
				narr[i] = M % 2;
				M = M / 2;
			}

			String result = "ON";
			for(int i = 0; i < N; i++) {
				if(narr[i] == 0) {
					result = "OFF";
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
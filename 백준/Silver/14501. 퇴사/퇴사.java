import java.util.Scanner;

public class Main {
	public static int[] T, P;
	public static int N, max = Integer.MIN_VALUE;;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N+1];
		P = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		DFS(1, 0); // 1일부터 시작
		
		System.out.println(max);
	}
	
	public static void DFS(int idx, int p) {
		if(idx > N) {
			max = Math.max(max, p);
			return;
		}
		
		int day = idx + T[idx];
		int price = p + P[idx];
		
		if(day <= N+1) { // 상담을 완료할 수 있다면
			DFS(day, price);
		}
		
		DFS(idx + 1, p);
	}
}
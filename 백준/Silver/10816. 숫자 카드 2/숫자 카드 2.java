import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for(int i = 0; i < N; i++) {
			arr1[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] arr2 = new int[M];
		for(int i = 0; i < M; i++) {
			arr2[i] = sc.nextInt();
		}
		
		// 카운팅 정렬
		int[] count = new int[20000002];
		for(int i = 0; i < arr1.length; i++) {
			count[arr1[i]+10000000]++;
		}
		
		for(int i = 0; i < arr2.length; i++) {
			sb.append(count[arr2[i]+10000000]).append(" ");
		}
		System.out.print(sb);
	}
}
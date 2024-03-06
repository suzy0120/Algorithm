import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		for(int n = 0; n < N; n++) {
			num[n] = sc.nextInt();
		}
		
		Arrays.sort(num);
		
		int[] sum = new int[N];
		sum[0] = num[0];
		for(int i = 1; i < N; i++) {
			sum[i] = sum[i-1] + num[i];
		}
		
		int min = 0;
		for(int i = 0; i < N; i++) {
			min += sum[i];
		}
		System.out.println(min);
	}
}

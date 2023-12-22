import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String s = sc.next();
		
		int[] num = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++) {
			num[i] = s.charAt(i) - '0';
			sum += num[i];
		}
		
		System.out.println(sum);
	}
}
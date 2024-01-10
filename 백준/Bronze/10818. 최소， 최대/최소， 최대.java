import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] number = new int[N];
		
		for(int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++) {
			if(max < number[i-1])
				max = number[i-1];
			if(min > number[i-1])
				min = number[i-1];
		}
		
		System.out.println(min + " " + max);
	}
}
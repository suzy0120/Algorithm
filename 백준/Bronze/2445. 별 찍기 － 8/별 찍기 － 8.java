import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i = 1; i <= 2*N-1; i++) {
			if(i <= N) {
				for(int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				for(int j = 1; j <= 2*(N-i); j++) {
					System.out.print(" ");
				}
				for(int j = 1; j <= i; j++) {
					System.out.print("*");
				}
			} else {
				for(int j = i-N; j < N; j++) {
					System.out.print("*");
				}
				for(int j = 1; j <= 2*(i-N); j++) {
					System.out.print(" ");
				}
				for(int j = i-N; j < N; j++) {
					System.out.print("*");
				}
			}
			
			System.out.println();
		}
	}
}
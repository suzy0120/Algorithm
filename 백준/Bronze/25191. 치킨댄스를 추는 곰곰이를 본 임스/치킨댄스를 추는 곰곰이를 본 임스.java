import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int chicken = 0;
		
		if((A/2 + B) <= N) chicken = A/2 + B;
		else chicken = N;
		
		System.out.println(chicken);
	}
}
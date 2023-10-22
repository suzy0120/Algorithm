import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0;
		
		for(int i = 1; i <= 1000000; i++) {
			int sum = i;
			int num = i;
			
			while(num > 0) {
				sum += num%10;
				num /= 10;
			}
			
			if(sum == N) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
}
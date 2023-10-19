import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			int result = 0;
			int[] arr = new int[44];
			
			for(int i = 1; i <= 44; i++) {
				arr[i-1] = i * (i+1) / 2; 
			}
			
			for(int i = 0; i < 44; i++) {
				for(int j = 0; j < 44; j++) {
					for(int k = 0; k < 44; k++) {
						if(K == (arr[i] + arr[j] + arr[k])) {
							result = 1;
						}
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
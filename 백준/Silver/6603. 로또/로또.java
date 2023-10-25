import java.util.Scanner;

public class Main {
	public static int k = -1;
	public static int[] S;
	public static int[] sel = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(k != 0) {
			k = sc.nextInt();
			S = new int[k];
			for(int i = 0; i < k; i++) {
				S[i] = sc.nextInt();
			}
			
			combination(0, 0);
			System.out.println();
		}
	}
	
	public static void combination(int idx, int sidx) {
		if(sidx == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = idx; i <= k-6+sidx; i++) {
			sel[sidx] = S[i];
			combination(i+1, sidx+1);
		}
	}
}
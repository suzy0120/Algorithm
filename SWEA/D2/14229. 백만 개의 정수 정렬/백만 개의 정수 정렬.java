import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] N = new int[1000000];
		for(int i = 0; i < 1000000; i++) {
			N[i] = sc.nextInt();
		}
		Arrays.sort(N);
		System.out.println(N[500000]);
	}
}
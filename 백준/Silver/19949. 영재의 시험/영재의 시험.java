import java.util.Scanner;

public class Main {
	public static int[] answer, result, number;
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = new int[10];
		for(int i = 0; i < 10; i++) {
			answer[i] = sc.nextInt();
		}
		
		result = new int[10];
		number = new int[5];
		for(int i = 0; i < 5; i++) {
			number[i] = i+1;
		}
		perm(0);
		System.out.println(count);
	}
	
	public static void perm(int idx) {
		if(idx == 10) {
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				if(answer[i] == result[i]) sum++;
			}
			if(sum >= 5) count++;
			return;
		}
		for(int i=0; i<5; i++) {
			if(idx>=2 && result[idx-2]==result[idx-1] && result[idx-2]==number[i]) continue;
			result[idx] = number[i];
			perm(idx+1);
		}
	}
}
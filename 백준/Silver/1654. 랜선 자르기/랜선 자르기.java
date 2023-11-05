import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
		int N = sc.nextInt(); // 필요한 랜선의 개수
		int[] arr = new int[K];
		long max = 0;
		for(int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();;
			if(max < arr[i]) max = arr[i];
		}
		max++;
		
		long min = 0;
		long mid = 0;
		while(min < max) { // min이 max보다 커지기 전까지 구한다.
			
			// 범위 내에서 중간 길이를 구한다.
			mid = (min+max) / 2;
			long count = 0;
			
			// 이분 탐색에서 사용하는 값은 중간값.
			for(int i = 0; i < K; i++) {
				count += (arr[i] / mid);
			}
			
			if(count < N) {
				max = mid;
			} else {
				min = mid +1;
			}
		}
		
		System.out.println(min-1);
	}
}
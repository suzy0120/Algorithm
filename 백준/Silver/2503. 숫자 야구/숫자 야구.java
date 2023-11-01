import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] qa = new int[N][3];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < 3; c++) {
				qa[r][c] = sc.nextInt();
			}
		}

		int possibility = 0; // 영수가 생각하고 있을 가능성
		for(int i = 1; i <= 9; i++) { // 백의 자리
			for(int j = 1; j <= 9; j++) { // 십의 자리
				for(int k = 1; k <= 9; k++) { // 일의 자리
					if(i == j || j == k || i == k) continue; // 서로 다른 숫자 세 개
					
					int count = 0;
					for(int r = 0; r < N; r++) {
						if(qa[r][1] == 3) { // 3 스트라이크가 되면 게임이 끝
							possibility++;
							continue;
						}
					
						int x = qa[r][0]/100; // 백의 자리
						int y = qa[r][0]%100/10; // 십의 자리
						int z = qa[r][0]%10; // 일의 자리
						
						int strike = 0;
						if (i == x) strike++;
						if (j == y) strike++;
						if (k == z) strike++;

						int ball = 0;
						if (i == y) ball++;
						if (i == z) ball++;
						if (j == x) ball++;
						if (j == z) ball++;
						if (k == x) ball++;
						if (k == y) ball++;
						
						if(qa[r][1] == strike && qa[r][2] == ball) {
							count++;
						}

						if(count == N) possibility++; // N개의 질문에 통과한 숫자의 개수
					}
				}
			}
		}
		
		System.out.println(possibility);
	}
}
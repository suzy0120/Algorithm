import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int N = sc.nextInt(); // 정점의 개수
			int M = sc.nextInt(); // 간선의 수
			
			int[][] adjArr = new int[N+1][N+1];
			
			for(int j = 0; j < M; j++) {
				int x = sc.nextInt(); // 시작정점
				int y = sc.nextInt(); // 끝정점
				
				adjArr[x][y] = adjArr[y][x] = 1;
			}

			int count = 0;
			for(int a = 1; a < N+1; a++) {
				for(int b = a+1; b < N+1; b++) {
					for(int c = b+1; c < N+1; c++) {
						if(adjArr[a][b] == 1 && adjArr[b][a] == 1 &&
						   adjArr[a][c] == 1 && adjArr[c][a] == 1 &&
						   adjArr[b][c] == 1 && adjArr[c][b] == 1) {
							count++;
						}
					}
				}
			}
			
			System.out.println("#" + i + " " + count);
		}
	}
}

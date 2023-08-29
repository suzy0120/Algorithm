import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] game = new char[H][W];
			for(int r = 0; r < H; r++) {
				game[r] = sc.next().toCharArray();
			}
			
			int N = sc.nextInt();
			char[] input = sc.next().toCharArray();
			
			for(int i = 0; i < N; i++) {
				loop : for(int r = 0; r < H; r++) {
					for(int c = 0; c < W; c++) {
						if(game[r][c] == '^' || game[r][c] == '>' || game[r][c] == 'v' || game[r][c] == '<') {
							if(input[i] == 'U') { // 위쪽이면
								if(r-1 >= 0 && game[r-1][c] == '.') { // 평지라면 위쪽 칸으로 이동
									game[r-1][c] = '^';
									game[r][c] = '.';
								} else { // 평지가 아니라면 전차 방향을 위쪽으로 바꿈
									game[r][c] = '^';
								}
							} else if(input[i] == 'D') { // 아래쪽이면
								if(r+1 < H && game[r+1][c] == '.') { // 평지라면 아래쪽 칸으로 이동
									game[r+1][c] = 'v';
									game[r][c] = '.';
								} else { // 평지가 아니라면 전차 방향을 아래쪽으로 바꿈
									game[r][c] = 'v';
								}
							} else if(input[i] == 'L') { // 왼쪽이면
								if(c-1 >= 0 && game[r][c-1] == '.') { // 평지라면 왼쪽 칸으로 이동
									game[r][c-1] = '<';
									game[r][c] = '.';
								} else { // 평지가 아니라면 전차 방향을 왼쪽으로 바꿈
									game[r][c] = '<';
								}
							} else if(input[i] == 'R') { // 오른쪽이면
								if(c+1 < W && game[r][c+1] == '.') { // 평지라면 오른쪽 칸으로 이동
									game[r][c+1] = '>';
									game[r][c] = '.';
								} else { // 평지가 아니라면 전차 방향을 오른쪽으로 바꿈
									game[r][c] = '>';
								}
							} else if(input[i] == 'S') { // 발사
								if(game[r][c] == '^') {
									int count = 0;
									while(r-count >= 0) {
										if(game[r-count][c] == '*') {
											game[r-count][c] = '.';
											break;
										} else if(game[r-count][c] == '#') {
											break;
										}
										count++;
									}
								} else if(game[r][c] == '>') {
									int count = 0;
									while(c+count < W) {
										if(game[r][c+count] == '*') {
											game[r][c+count] = '.';
											break;
										} else if(game[r][c+count] == '#') {
											break;
										}
										count++;
									}
								} 
								else if(game[r][c] == 'v') {
									int count = 0;
									while(r+count < H) {
										if(game[r+count][c] == '*') {
											game[r+count][c] = '.';
											break;
										} else if(game[r+count][c] == '#') {
											break;
										}
										count++;
									}
								} else if(game[r][c] == '<') {
									int count = 0;
									while(c-count >= 0) {
										if(game[r][c-count] == '*') {
											game[r][c-count] = '.';
											break;
										} else if(game[r][c-count] == '#') {
											break;
										}
										count++;
									}
								}
							}
							break loop;
						}
					}
				}
			}
			// 출력
			System.out.print("#" + tc + " ");
			for(int r = 0; r < H; r++) {
				System.out.println(game[r]);
			}
		}
	}
}
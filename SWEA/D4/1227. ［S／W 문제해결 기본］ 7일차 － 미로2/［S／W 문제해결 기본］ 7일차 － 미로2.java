import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] miro;
	static boolean[][] visit;
	static int answer, nr, nc;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			miro = new int[100][100];
			
			for(int r = 0; r < 100; r++) {
				char[] cArr = sc.next().toCharArray();
				for(int c = 0; c < 100; c++) {
					miro[r][c] = cArr[c] - '0';
				}
			}
			
			visit = new boolean[100][100];
			answer = 0;
			BFS(1,1);
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void BFS(int r, int c) {
		Queue<Integer[]> q = new LinkedList<>();
		q.add(new Integer[] {r, c});
		
		while(!q.isEmpty()) {
			Integer[] rc = q.poll();
			r = rc[0];
			c = rc[1];
			
			for(int d = 0; d < 4; d++) {
				if(miro[nr][nc] == 3) {
					answer = 1;
				}
				nr = r + dr[d];
				nc = c + dc[d];
				if(!(0 <= nr && 0 <= nc && nr < 100 && nc < 100) || miro[nr][nc] == 1 || visit[nr][nc]) continue;
				visit[nr][nc] = true;
		        q.add(new Integer[] {nr, nc});
			}
		}
	}
}
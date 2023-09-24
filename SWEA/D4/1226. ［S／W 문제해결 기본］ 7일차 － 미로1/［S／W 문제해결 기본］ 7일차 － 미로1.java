import java.util.Scanner;

public class Solution {
	// 우 하 좌 상 탐색
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] miro;
	static boolean[][] visit;
	static int answer, nr, nc;
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	for(int tc = 1; tc <= 10; tc++) {
    		int T = sc.nextInt();
    		miro = new int[16][16];
    		
    		for(int r = 0; r < 16; r++) {
    			char[] cArr = sc.next().toCharArray();
    			for(int c = 0; c < 16; c++) {
    				miro[r][c] = cArr[c] - '0';
    			}
    		}
    		
    		visit = new boolean[16][16];
    		answer = 0;
    		DFS(1,1);
    		
    		System.out.println("#" + tc + " " + answer);
    	}
    }
    
    // 재귀
    public static void DFS(int r, int c) {
    	if(miro[nr][nc] == 3) {
    		answer = 1;
    	}
    	for(int d = 0; d < 4; d++) {
    		nr = r + dr[d];
    		nc = c + dc[d];
    		if(!(0 <= nr && 0 <= nc && nr < 16 && nc < 16) || miro[nr][nc] == 1 || visit[nr][nc]) continue;
    		visit[nr][nc] = true; // 방문 처리
    		DFS(nr, nc);
    	}
    }
}
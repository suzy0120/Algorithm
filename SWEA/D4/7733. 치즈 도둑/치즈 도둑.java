import java.util.Scanner;

public class Solution {
	// 우 하 좌 상 탐색
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N;
	static int[][] cheese;
	static boolean[][] visit;
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for(int tc = 1; tc <= T; tc++) {
    		N = sc.nextInt();
    		cheese = new int[N][N];
    		
    		for(int r = 0; r < N; r++) {
    			for(int c = 0; c < N; c++) {
    				cheese[r][c] = sc.nextInt();
    			}
    		}
    		
    		int answer = 1;
    		
    		for(int i = 1; i <= 100; i++) {
    			// 치즈 먹기
    			for(int r = 0; r < N; r++) {
        			for(int c = 0; c < N; c++) {
        				if(cheese[r][c] == i) cheese[r][c] = 0; // 그 날 먹은 치즈 '0' 으로 바꿔주기
        			}
        		}
    			
    			visit = new boolean[N][N];
    			int count = 0;
    			
    			// 덩어리 개수 세기
    			for(int r = 0; r < N; r++) {
        			for(int c = 0; c < N; c++) {
        				if(visit[r][c] || cheese[r][c] == 0) continue; // 방문을 했거나 갉아 먹은 곳이라면 건너뛰기 !
        				visit[r][c] = true; // 방문 처리
        				dfs(r, c);
        				count++;
        			}
        		}
    			
    			answer = Math.max(answer, count);
    		}
    		
    		System.out.println("#" + tc + " " + answer);
    	}
    }
    
    // 재귀
    public static void dfs(int r, int c) {
    	for(int d = 0; d < 4; d++) {
    		int nr = r + dr[d];
    		int nc = c + dc[d];
    		if(!(0 <= nr && 0 <= nc && nr < N && nc < N) || cheese[nr][nc] == 0 || visit[nr][nc]) continue;  // 치즈 크기에 벗어나거나 방문을 했거나 갉아 먹은 곳이라면 건너뛰기 !
    		visit[nr][nc] = true; // 방문 처리
    		dfs(nr, nc);
    	}
    }
}
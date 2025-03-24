import java.util.*;

class Solution {
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};
    public static int N, M;
    public static char[][] map;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        
        int startR = 0, startC = 0;
        for(int r=0; r<N; r++) {
            map[r] = maps[r].toCharArray();
            for(int c=0; c<M; c++) {
                if(map[r][c] == 'S') {
                    startR = r;
                    startC = c;
                }
            }
        }
        
        int[] result = BFS(startR, startC, 0, 'L');
        if(result == null) return -1;
        
        result = BFS(result[0], result[1], result[2], 'E');
        return (result == null) ? -1 : result[2];
    }
    
    private int[] BFS(int r, int c, int dist, char target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c, dist});
        
        boolean[][] visit = new boolean[N][M];
        visit[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cd = cur[2];
            
            if(map[cr][cc] == target) return new int[] {cr, cc, cd};
            
            for(int d=0; d<4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(!(0<=nr && nr<N && 0<=nc && nc<M) || map[nr][nc]=='X' || visit[nr][nc]) continue;
                
                visit[nr][nc] = true;
                q.add(new int[] {nr, nc, cd+1});
            }
        }
        
        return null;
    }
}
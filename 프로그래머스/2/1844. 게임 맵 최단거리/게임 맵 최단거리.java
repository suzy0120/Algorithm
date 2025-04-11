import java.util.*;

class Solution {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};
    boolean[][] visit;
    int answer, n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visit = new boolean[n][m];
        
        visit[0][0] = true;
        
        answer = BFS(0, 0, maps);
        return answer;
    }
    
    private int BFS(int r, int c, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c, 1});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cnt = cur[2];
            
            if(cur[0]==(n-1) && cur[1]==(m-1)) return cnt;
            
            for(int d=0; d<4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if(nr<0 || n<=nr || nc<0 || m<=nc) continue;
                if(maps[nr][nc]==0 || visit[nr][nc]) continue;
                
                visit[nr][nc] = true;
                q.add(new int[] {nr, nc, cnt+1});
            }
        }
        
        return -1;
    }
}
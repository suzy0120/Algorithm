import java.util.*;

class Solution {
    
    public static int[] dr = {0, 0, 1, -1};
    public static int[] dc = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit = new boolean[n][m];
        
        int answer = BFS(n, m, maps, visit);
        return answer;
    }
    
    public int BFS(int n, int m, int[][] maps, boolean[][] visit) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        visit[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            if(r==n-1 && c==m-1) return cnt;
            
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr<0 || nr>=n || nc<0 || nc>=m) continue;
                if(maps[nr][nc]==0 || visit[nr][nc]) continue;
                
                visit[nr][nc] = true;
                q.add(new int[]{nr, nc, cnt+1});
            }
        }
        
        return -1;
    }
}
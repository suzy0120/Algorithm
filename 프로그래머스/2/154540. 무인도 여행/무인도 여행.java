import java.util.*;

class Solution {
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};
    public static int N, M;
    public static char[][] map;
    public static boolean[][] visit;
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];
        visit = new boolean[N][M];
        
        for(int r=0; r<N; r++) {
            map[r] = maps[r].toCharArray();
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(map[r][c] == 'X' || visit[r][c]) continue;
                
                list.add(DFS(r, c));
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i); 
        }
        
        return answer;
    }
    
    private int DFS(int r, int c) {
        visit[r][c] = true;
        int sum = map[r][c] - '0';
        
        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr<0 || N<=nr || nc<0 || M<=nc) continue;
            if(map[nr][nc]=='X' || visit[nr][nc]) continue;
            
            sum += DFS(nr, nc);
        }
        
        return sum;
    }
}
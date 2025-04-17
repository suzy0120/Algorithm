import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        Set<String> visited = new HashSet<>();
        
        int answer = 0;
        int cr = 0, cc = 0;
        
        for(char c : dirs.toCharArray()) {
            int d = -1;
            
            if(c == 'U') d = 0;
            else if(c == 'D') d = 1;
            else if(c == 'R') d = 2;
            else d = 3;
            
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            
            if(nr<-5 || nr>5 || nc<-5 || nc>5) continue;
            
            String path = cr + "," + cc + "->" + nr + "," + nc;
            String reversePath = nr + "," + nc + "->" + cr + "," + cc;
            
            if(!visited.contains(path) && !visited.contains(reversePath)) {
                visited.add(path);
                visited.add(reversePath);
                answer++;
            }
            
            cr = nr;
            cc = nc;
        }
        
        return answer;
    }
}
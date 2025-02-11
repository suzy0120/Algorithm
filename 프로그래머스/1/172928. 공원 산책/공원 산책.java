class Solution {
    public int[] solution(String[] park, String[] routes) {
        int R = park.length;
        int C = park[0].length();
        int row = 0, col = 0;
        for(int i=0; i<R; i++) {
            int idx = park[i].indexOf('S');
            if(idx != -1) {
                row = i;
                col = idx;
                break;
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        char[] dirs = {'N', 'S', 'W', 'E'};
        for(String s : routes) {
            char c = s.charAt(0);
            int step = s.charAt(2)-'0';
            int nr = row, nc = col;
            boolean canMove = true;
            for(int i=0; i<step; i++) {
                for(int j=0; j<4; j++) {
                    if(c==dirs[j]) {
                        nr+=dr[j];
                        nc+=dc[j];
                        break;
                    }
                }
                
                if(nr<0 || R<=nr || nc<0 || C<=nc || park[nr].charAt(nc)=='X') {
                    canMove = false;
                    break;
                }
            }
            
            if(canMove) {
                row = nr;
                col = nc;
            }
        }
        
        int[] answer = {row, col};
        return answer;
    }
}
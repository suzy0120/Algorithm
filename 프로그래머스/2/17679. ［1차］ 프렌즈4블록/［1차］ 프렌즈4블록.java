import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] cBoard = new char[m][n];
        for(int r=0; r<m; r++) {
            cBoard[r] = board[r].toCharArray();
        }
        
        while(true) {
            boolean[][] visited = new boolean[m][n];
            boolean found = false;
            
            for(int r=0; r<m-1; r++) {
                for(int c=0; c<n-1; c++) {
                    char base = cBoard[r][c];
                    if(base != 'x' &&
                       base == cBoard[r+1][c] &&
                       base == cBoard[r][c+1] &&
                       base == cBoard[r+1][c+1]) {
                        visited[r][c] = visited[r+1][c] = visited[r][c+1] = visited[r+1][c+1] = true;
                        found = true;
                    }
                }
            }
            
            if(!found) break;
            
            for(int r=0; r<m; r++) {
                for(int c=0; c<n; c++) {
                    if(visited[r][c]) {
                        answer++;
                        cBoard[r][c] = 'x';
                    }
                }
            }
            
            for(int c=0; c<n; c++) {
                int idx = m-1;
                
                for(int r=m-1; r>=0; r--) {
                    if(cBoard[r][c] != 'x') {
                        cBoard[idx--][c] = cBoard[r][c];
                    }
                }
                
                while(idx >= 0) {
                    cBoard[idx--][c] = 'x';
                }
            }
        }
        
        return answer;
    }
}
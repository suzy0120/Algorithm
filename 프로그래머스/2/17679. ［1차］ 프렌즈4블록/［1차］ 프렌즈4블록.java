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
                    
                    if(base != 'x' && base == cBoard[r+1][c] &&
                       base == cBoard[r][c+1] && base == cBoard[r+1][c+1]) {
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
                List<Character> list = new ArrayList<>();
                
                for(int r=m-1; r>=0; r--) {
                    if(cBoard[r][c] != 'x') list.add(cBoard[r][c]);
                }
                
                int row = m-1;
                for(char ch : list) cBoard[row--][c] = ch;
                
                while(row >= 0) {
                    cBoard[row--][c] = 'x';
                }
            }
        }
        
        return answer;
    }
}
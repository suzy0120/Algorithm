import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] game = new char[m][n];
        for(int r=0; r<m; r++) {
            game[r] = board[r].toCharArray();
        }
        
        int answer = 0;
        while(true) {
            boolean[][] visited = new boolean[m][n];
            boolean found = false;
            
            for(int r=0; r<m-1; r++) {
                for(int c=0; c<n-1; c++) {
                    if(game[r][c] != 'x' && game[r][c] == game[r][c+1] && game[r][c] == game[r+1][c] && game[r][c] == game[r+1][c+1]) {
                        visited[r][c] = visited[r][c+1] = visited[r+1][c] = visited[r+1][c+1] = true;
                        found = true;
                    }
                }
            }
            
            if(!found) break;
            
            for(int r=0; r<m; r++) {
                for(int c=0; c<n; c++) {
                    if(visited[r][c]) {
                        game[r][c] = 'x';
                        answer++;
                    }
                }
            }
            
            for(int c=0; c<n; c++) {
                int row = m-1;
                for(int r=m-1; r>=0; r--) {
                    if(game[r][c] != 'x') game[row--][c] = game[r][c];
                }
                
                while(row >= 0) {
                    game[row--][c] = 'x';
                }
            }
        }
        
        return answer;
    }
}
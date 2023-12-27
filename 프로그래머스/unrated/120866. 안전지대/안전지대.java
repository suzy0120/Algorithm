class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board.length; c++) {
                if(board[r][c] == 1) {
                    for(int i = 0; i < 8; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if((0 <= nr && nr < board.length && 0 <= nc && nc < board.length) &&
                           board[nr][nc] != 1) board[nr][nc] = 2;
                    }
                }
            }
        }
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board.length; c++) {
                if(board[r][c] == 0) answer++;
            }
        }
        
        return answer;
    }
}
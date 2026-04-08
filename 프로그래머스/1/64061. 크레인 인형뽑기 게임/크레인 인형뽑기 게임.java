import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<moves.length; i++) {
            int x = moves[i]-1;
            for(int y=0; y<board.length; y++) {
                int value = board[y][x];
                if(value == 0) continue;
                
                board[y][x] = 0;
                if(list.size() > 0 && list.get(list.size()-1) == value) {
                    list.remove(list.size() - 1);
                    answer+=2;
                    break;
                }

                list.add(value);
                break;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = 0;
        int y = 0;
        
        for(int i = 0; i < 4; i++) {
            for(int j = i+1; j < 4; j++) {
                if(dots[i][0] == dots[j][0]) {
                    x = Math.abs(dots[i][1] - dots[j][1]);
                    break;
                }
            }
            for(int j = i+1; j < 4; j++) {
                if(dots[i][1] == dots[j][1]) {
                    y = Math.abs(dots[i][0] - dots[j][0]);
                    break;
                }
            }
        }
        
        answer = x * y;
        return answer;
    }
}
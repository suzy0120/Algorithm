import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        
        double[] avg = new double[score.length];
        for(int i=0; i<score.length; i++) {
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
        }
        
        Arrays.fill(answer, 1);
        
        for(int i=0; i<score.length; i++) {
            for(int j=0; j<score.length; j++) {
                if(avg[j] > avg[i]) answer[i]++;
            }
        }
        
        return answer;
    }
}
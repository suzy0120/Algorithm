import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int num = score.length;
        Arrays.sort(score);
        
        while(num >= m) {
            int min = Integer.MAX_VALUE;
            
            for(int i=num-1; i>=num-m; i--) {
                if(min > score[i]) min = score[i];
            }
            
            answer += min*m;
            num -= m;
        }
        
        return answer;
    }
}
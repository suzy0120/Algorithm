import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int[][] dp = new int[park.length][park[0].length];
        int max = Integer.MIN_VALUE;
        for(int r=0; r<park.length; r++) {
            for(int c=0; c<park[0].length; c++) {
                if(park[r][c].equals("-1")) {
                    if(r==0 || c==0) dp[r][c] = 1;
                    else dp[r][c] = Math.min(dp[r-1][c], Math.min(dp[r][c-1], dp[r-1][c-1]))+1;
                    max = Math.max(max, dp[r][c]);
                } else dp[r][c] = 0;
            }
        }
        
        Arrays.sort(mats);
        int answer = -1;
        for(int i=mats.length-1; i>=0; i--) {
            if(mats[i] <= max) {
                answer = mats[i];
                break;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        if(n == 1) answer = 1;
        
        Arrays.sort(citations);
        
        int h = citations[n-1];
        loop: while(h > 0) {
            int count = 0;
            for(int i = n-1; i>=0; i--) {
                if(citations[i] >= h) count++;
                if(count == h) {
                    answer = h;
                    break loop;
                }
            }
            h--;
        }
        
        return answer;
    }
}
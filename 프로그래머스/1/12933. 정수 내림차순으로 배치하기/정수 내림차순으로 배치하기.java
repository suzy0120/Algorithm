import java.util.*;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        char[] cArr = s.toCharArray();
        
        Arrays.sort(cArr);
        
        StringBuilder sb = new StringBuilder(new String(cArr));
        sb.reverse();
        
        long answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}
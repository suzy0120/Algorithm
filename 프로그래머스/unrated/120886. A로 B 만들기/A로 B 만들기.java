import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        int[] f = new int[before.length()];
        int[] b = new int[after.length()];
        for(int i = 0; i < before.length(); i++) {
            f[i] = before.charAt(i);
        }
        for(int i = 0; i < after.length(); i++) {
            b[i] = after.charAt(i);
        }
        Arrays.sort(f);
        Arrays.sort(b);
        int count = 0;
        for(int i = 0; i < before.length(); i++) {
            if(f[i] == b[i]) count++;
        }
        if(count == before.length()) answer = 1;
        return answer;
    }
}
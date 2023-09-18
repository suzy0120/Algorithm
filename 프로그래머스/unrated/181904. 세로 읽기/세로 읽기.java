import java.util.*;

class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String[] s = new String[my_string.length()/m];
        int idx = 0;
        int n = 0;
        for(int i = 0; i < my_string.length(); i+=m) {
            s[idx++] = my_string.substring(i, i+m);
        }
        for(int i = 0; i < s.length; i++) {
            answer+=s[i].charAt(c-1);
        }
        return answer;
    }
}
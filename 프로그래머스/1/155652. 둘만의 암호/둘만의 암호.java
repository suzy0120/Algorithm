import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(char c : s.toCharArray()) {
            int count = 0;
            while(count < index) {
                c++;
                if(c > 'z') c = 'a';
                boolean isSkip = false;
                for(char cArr : skip.toCharArray()) {
                    if(c==cArr) {
                        isSkip = true;
                        break;
                    }
                }
                if(!isSkip) count++;
            }
            answer += c;
        }
        
        return answer;
    }
}
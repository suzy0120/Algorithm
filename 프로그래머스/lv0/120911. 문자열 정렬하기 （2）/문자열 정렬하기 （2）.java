import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = my_string.toLowerCase();
        String[] arr = new String[my_string.length()];
        arr = answer.split("");
        Arrays.sort(arr);
        answer = "";
        for(String n : arr) {
            answer += n;
        }
        return answer;
    }
}
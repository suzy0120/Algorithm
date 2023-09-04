import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        String[] sArr = my_string.split("");
        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            while(left < right) {
                String temp = sArr[right];
                sArr[right--] = sArr[left];
                sArr[left++] = temp;
            }
        }
        for(int i = 0; i < sArr.length; i++) {
            answer += sArr[i];
        }
        return answer;
    }
}
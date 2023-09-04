import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = ""; // StringBuilder
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        int[] ASCII = new int[123];
        for(int i = 0; i < chArr.length; i++) {
            ASCII[chArr[i]]++;
        }
        for(int i = 0; i < chArr.length; i++) {
            if(ASCII[chArr[i]] == 1) {
                answer += chArr[i];
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for(char[] c : type) {
            hm.put(c[0], 0);
            hm.put(c[1], 0);
        }
        
        for(int i=0; i<survey.length; i++) {
            if(choices[i] <= 4) {
                hm.put(survey[i].charAt(0), hm.get(survey[i].charAt(0))+score[choices[i]]);
            } else {
                hm.put(survey[i].charAt(1), hm.get(survey[i].charAt(1))+score[choices[i]]);
            }
        }
        
        for(char[] c : type) {
            answer += (hm.get(c[0]) >= hm.get(c[1])) ? c[0] : c[1];
        }
        
        return answer;
    }
}
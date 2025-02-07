import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        String[] s = dartResult.split("(?<=\\D)(?=\\d)");
        
        for(int i=0; i<s.length; i++) {
            int index = 0;
            while(index < s[i].length() && Character.isDigit(s[i].charAt(index))) {
                index++;
            }
            int score = Integer.parseInt(s[i].substring(0, index));
            
            char bonus = s[i].charAt(index);
            if(bonus=='S')      score = (int) Math.pow(score, 1);
            else if(bonus=='D') score = (int) Math.pow(score, 2);
            else if(bonus=='T') score = (int) Math.pow(score, 3);
            
            if(s[i].length() > index+1) {
                char option = s[i].charAt(index+1);
                if(option=='*') {
                    score*=2;
                    if(i>0) scores[i-1]*=2;
                } else if(option=='#') {
                    score*=-1;
                }
            }
            scores[i] = score;
        }
        
        int answer = 0;
        for(int n : scores) answer+=n;
        
        return answer;
    }
}
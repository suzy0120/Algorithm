class Solution {
    public String solution(String s) {
        String[] word = s.split(" ", -1);
        
        for(int i=0; i<word.length; i++) {
            if(word[i].length() > 0) {
                word[i] = Character.toUpperCase(word[i].charAt(0)) + word[i].substring(1).toLowerCase();
            }
        }
        
        String answer = "";
        for(int i=0; i<word.length; i++) {
            answer += word[i];
            if(i != word.length-1) answer += " ";
        }
        
        return answer;
    }
}
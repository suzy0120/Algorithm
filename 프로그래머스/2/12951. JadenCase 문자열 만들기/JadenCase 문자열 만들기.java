class Solution {
    public String solution(String s) {
        String answer = "";
        String[] word = s.split(" ", -1);
        
        for(int i=0; i<word.length; i++) {
            if(word[i].length() > 0) {
                char c = word[i].charAt(0);
                answer += Character.toUpperCase(c) + word[i].substring(1).toLowerCase();
            }
            
            if(i == word.length-1) break;
            answer += " ";
        }
        
        return answer;
    }
}
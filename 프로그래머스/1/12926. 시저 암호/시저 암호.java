class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) {
                answer += (char) ((c - 'a' + n) % 26 + 'a');
            } else if(Character.isUpperCase(c)) {
                answer += (char) ((c - 'A' + n) % 26 + 'A');
            } else {
                answer += c;
            }
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String myString) {
        String answer = "";
        String[] s = myString.split("");
        for(int i = 0; i < myString.length(); i++) {
            if(s[i].equals("a")) {
                answer += s[i].toUpperCase();
            } else if(s[i].equals("A")) {
                answer += s[i];
            } else {
                answer += s[i].toLowerCase();
            }
        }
        return answer;
    }
}
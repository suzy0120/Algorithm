class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i = 0; i < myString.length(); i++) {
            if(pat.charAt(pat.length() - 1) == myString.charAt(i)) {
                answer = myString.substring(0, i+1);
            }
        }
        return answer;
    }
}
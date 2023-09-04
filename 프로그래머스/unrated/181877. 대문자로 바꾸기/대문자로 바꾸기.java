class Solution {
    public String solution(String myString) {
        String answer = "";
        int n;
        for(int i = 0; i < myString.length(); i++) {
            n = myString.charAt(i);
            if(n >= 97) {
                answer += (char)(n - 32);
            } else {
                answer += (char)n;
            }
        }
        return answer;
    }
}
class Solution {
    public String solution(int num) {
        String answer = String.valueOf(num%2);
        
        return answer.equals("0") ? "Even" : "Odd";
    }
}
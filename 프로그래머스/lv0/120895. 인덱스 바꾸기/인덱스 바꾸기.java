class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char first = my_string.charAt(num1);
        char last = my_string.charAt(num2);
        for(int i = 0; i < my_string.length(); i++) {
            if(i == num1) {
                answer += last;
                continue;
            } else if(i == num2) {
                answer += first;
                continue;
            }
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
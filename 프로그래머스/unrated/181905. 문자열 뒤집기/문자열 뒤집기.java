class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        answer += my_string.substring(0, s);
        int sum = e;
        while(s <= sum) {
            answer += my_string.charAt(sum--);
        }
        answer += my_string.substring(e+1, my_string.length());
        return answer;
    }
}
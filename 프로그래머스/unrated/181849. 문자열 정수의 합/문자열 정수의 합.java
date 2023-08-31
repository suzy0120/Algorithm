class Solution {
    public int solution(String num_str) {
        int answer = 0;
        char[] c = num_str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            answer += c[i] - '0';
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 1;
        loop: for(int i = 3; i <= n; i++) {
            for(int j = 2; j < Math.sqrt(i)+1; j++) {
                if(i % j == 0) continue loop;
            }
            answer++;
        }
        return answer;
    }
}
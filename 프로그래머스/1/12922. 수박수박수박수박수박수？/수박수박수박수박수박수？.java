class Solution {
    public String solution(int n) {
        String answer = "";
        
        for(int i=1; i<=n; i++) {
            char c = i%2==1 ? '수' : '박';
            answer +=c;
        }
        
        return answer;
    }
}
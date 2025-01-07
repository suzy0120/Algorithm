class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            int total = 0;
            for(int j=1; j<=i; j++) {
                if(i%j==0) total++;
            }
            if(total%2==0) answer+=i;
            else answer-=i;
        }
        
        return answer;
    }
}
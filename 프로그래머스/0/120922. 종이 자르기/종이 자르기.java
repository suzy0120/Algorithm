class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        
        if(M > 1 || N > 1) answer = (M-1) + M * (N-1);
        
        return answer;
    }
}
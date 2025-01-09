class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=Math.max(n,m); i++) {
            if(i>Math.min(n,m)) break;
            if(n%i==0 && m%i==0) max = i;
        }
        
        answer[0] = max;
        answer[1] = n*m/answer[0];
        
        return answer;
    }
}
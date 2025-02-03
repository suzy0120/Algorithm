class Solution {
    public long solution(long n) {
        long answer = -1;
        double num = Math.sqrt(n);
        
        if(num == Math.floor(num)) {
            long next = (long) num + 1;
            answer = next * next;
        }
        
        return answer;
    }
}
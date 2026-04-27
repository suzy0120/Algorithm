class Solution {
    public int solution(int num) {
        long n = (long) num;
        int answer = 0;
        
        while(n > 1 && answer < 500) {
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
            answer++;
        }
        
        return n == 1 ? answer : -1;
    }
}
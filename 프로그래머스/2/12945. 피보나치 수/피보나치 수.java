class Solution {
    public int solution(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        int a = 1, b = 1;
        for(int i=3; i<=n; i++) {
            int next = (a+b) % 1234567;
            a = b;
            b = next;
        }
        
        return b;
    }
}
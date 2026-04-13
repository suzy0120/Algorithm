class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int org = x;
        int sum = 0;
        while(x > 0) {
            sum += x%10;
            x /= 10;
        }
        
        if(org % sum != 0) answer = false;
        return answer;
    }
}
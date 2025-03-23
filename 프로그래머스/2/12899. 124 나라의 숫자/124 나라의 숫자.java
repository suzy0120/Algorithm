class Solution {
    public String solution(int n) {
        String[] num = {"1", "2", "4"};
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            if(n%3 == 1) sb.append(num[0]);
            else if(n%3 == 2) sb.append(num[1]);
            else {
                sb.append(num[2]);
                n = n/3 - 1;
                continue;
            }
            
            n/=3;
        }
        
        String answer = sb.reverse().toString();
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int quotient = n;
        int remainder = 0;
        String sNum = "";
        
        while(quotient > 0) {
            remainder = quotient % 3;
            sNum += remainder;
            quotient = quotient / 3;
        }
        
        int answer = 0;
        for(int i=0; i<sNum.length(); i++) {
            char c = sNum.charAt(i);
            int digit = c - '0';
            answer = answer*3 + digit;
        }
        
        return answer;
    }
}
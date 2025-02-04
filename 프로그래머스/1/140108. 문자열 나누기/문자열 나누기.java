class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = 0;
        int countX = 0;
        int countOther = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(countX==0 && countOther==0) {
                x = s.charAt(i);
                countX++;
                continue;
            }   
                
            if(x != s.charAt(i)) countOther++;
            else countX++;
            
            if(countX == countOther) {
                answer++;
                countX = 0;
                countOther = 0;
            }
        }
        
        if(countX!=0 || countOther !=0) answer++;
        
        return answer;
    }
}
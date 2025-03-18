class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int len = A.length();
        
        for(int i=0; i<len; i++) {
            if(A.equals(B)) {
                answer = i;
                break;
            }
            
            A = A.charAt(len-1) + A.substring(0, len-1);
        }
        
        return answer;
    }
}
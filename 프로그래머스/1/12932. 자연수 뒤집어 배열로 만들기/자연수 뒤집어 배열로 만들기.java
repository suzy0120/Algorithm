class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            answer[i] = s.charAt(s.length() - 1 - i) - '0';
        }
        
        return answer;
    }
}
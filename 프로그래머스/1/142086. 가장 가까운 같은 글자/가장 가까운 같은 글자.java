class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        if (s.length() == 1) {
            answer[0] = -1;
            return answer;
        }
        
        answer[0] = -1;
        if(s.charAt(1) != s.charAt(0)) answer[1] = -1;
        else answer[1] = 1;
        
        for(int i=2; i<s.length(); i++) {
            for(int j=i-1; j>=0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    answer[i] = i-j;
                    break;
                }
            }
            if(answer[i] == 0) answer[i] = -1;
        }
        
        return answer;
    }
}
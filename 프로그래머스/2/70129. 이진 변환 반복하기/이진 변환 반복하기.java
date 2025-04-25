class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int len = s.length();
        
        while(len != 1) {
            int count = 0;
            
            for(char c : s.toCharArray()) {
                if(c == '0') count++;
            }
            
            answer[1] += count;
            len = s.length() - count;
            s = Integer.toBinaryString(len);
            answer[0]++;
        }
        
        return answer;
    }
}
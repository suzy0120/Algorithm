class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int count = 0;
            
            for(char c : s.toCharArray()) {
                if(c == '0') answer[1]++;
                else count++;
            }
            
            s = Integer.toBinaryString(count);
            answer[0]++;
        }
        
        return answer;
    }
}
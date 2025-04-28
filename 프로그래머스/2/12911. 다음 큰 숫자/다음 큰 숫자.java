class Solution {
    public int solution(int n) {
        int answer = 0;
        int next = n+1;
        
        String str1 = Integer.toBinaryString(n);
        int cnt1 = 0;
        for(char c : str1.toCharArray()) {
            if(c == '1') cnt1++;
        }
        
        while(next > n) {
            String str2 = Integer.toBinaryString(next);
            int cnt2 = 0;
            for(char c : str2.toCharArray()) {
                if(c == '1') cnt2++;
            }
            
            if(cnt1 == cnt2) {
                answer = Integer.parseInt(str2, 2);
                break;
            }
            
            next++;
        }
        
        return answer;
    }
}
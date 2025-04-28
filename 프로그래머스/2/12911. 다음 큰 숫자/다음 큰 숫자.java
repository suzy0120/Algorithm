class Solution {
    public int solution(int n) {
        String str = Integer.toBinaryString(n);
        int cnt1 = 0;
        
        for(char c : str.toCharArray()) {
            if(c == '1') cnt1++;
        }
        
        while(true) {
            n++;
            String next = Integer.toBinaryString(n);
            int cnt2 = 0;
            
            for(char c : next.toCharArray()) {
                if(c == '1') cnt2++;
            }
            
            if(cnt1 == cnt2) break;
        }
        
        return n;
    }
}
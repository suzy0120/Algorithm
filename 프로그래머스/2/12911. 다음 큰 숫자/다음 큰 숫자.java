class Solution {
    public int solution(int n) {
        int answer = 0;
        int next = n+1;
        
        String n1 = Integer.toBinaryString(n);
        int count1 = 0;
        for(char c1 : n1.toCharArray()) {
            if(c1 == '1') count1++;
        }
        
        while(next > n) {
            String n2 = Integer.toBinaryString(next);
            int count2 = 0;
            for(char c2 : n2.toCharArray()) {
                if(c2 == '1') count2++;
            }
            
            if(count1 == count2) {
                answer = Integer.parseInt(n2, 2);
                break;
            }
            
            next++;
        }
        
        return answer;
    }
}
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        char[] c = new char[m*t];
        int idx = 0;
        loop: for(int i=0; i<100000; i++) {
            String s = Integer.toString(i, n);
            
            for(int j=0; j<s.length(); j++) {
                if(idx == c.length) break loop;
                c[idx++] = s.charAt(j);
            }
        }
        
        int count = 0;
        for(int i=p-1; i<c.length; i+=m) {
            answer += String.valueOf(Character.toUpperCase(c[i]));
            count++;
            if(count == t) break;
        }
        
        return answer;
    }
}
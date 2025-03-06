import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        for(char c : s.toCharArray()) {
            if(c != '0') {
                sb.append(c);
            } else {
                if(sb.length() != 0) list.add(sb.toString());
                sb.setLength(0);
            }
        }
        
        if(sb.length() != 0) list.add(sb.toString());
        
        int answer = 0;
        for(String str : list) {
            long num = Long.parseLong(str);
            
            if(isPrime(num)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if(num < 2) return false;
        
        for(long i=2; i*i<=num; i++) {
            if(num%i == 0) return false;
        }
        
        return true;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] count = new int[elements.length];
        int num = 0;
        
        while(num < elements.length) {
            for(int i=0; i<elements.length; i++) {
                int idx = i+num;
                if(idx >= elements.length) idx %= elements.length;
                count[i] += elements[idx];
                
                set.add(count[i]);
            }
            
            num++;
        }
        
        int answer = set.size();
        return answer;
    }
}
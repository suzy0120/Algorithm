import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<=discount.length-10; i++) {
            for(int j=0; j<want.length; j++) {
                map.put(want[j], number[j]);
            }
            
            int count = 0;
            for(int j=i; j<i+10; j++) {
                if(map.containsKey(discount[j]) && map.get(discount[j])>0) {
                    map.replace(discount[j], map.get(discount[j])-1);
                    count++;
                } else break;
                
                if(count == 10) answer++;
            }
        }
        
        return answer;
    }
}
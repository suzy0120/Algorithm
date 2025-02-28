import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))) {
                String s = str1.substring(i, i+2);
                
                map1.put(s, map1.getOrDefault(s, 0)+1);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++) {
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))) {
                String s = str2.substring(i, i+2);
                
                map2.put(s, map2.getOrDefault(s, 0)+1);
            }
        }
        
        Set<String> keys = new HashSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        int same = 0;
        int sum = 0;
        for(String key : keys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            same += Math.min(count1, count2);
            sum += Math.max(count1, count2);
        }
        
        if(sum == 0) return 65536;
        
        int answer = same * 65536 / sum;
        return answer;
    }
}
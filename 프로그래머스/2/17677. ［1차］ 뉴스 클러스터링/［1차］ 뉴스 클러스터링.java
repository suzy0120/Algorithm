import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map = new HashMap<>();
        
        int count1 = 0;
        for(int i=0; i<str1.length()-1; i++) {
            if(Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i+1))) {
                String s = str1.substring(i, i+2);
                
                map.put(s, map.getOrDefault(s, 0)+1);
                
                count1++;
            }
        }
        
        int same = 0;
        int count2 = 0;
        for(int i=0; i<str2.length()-1; i++) {
            if(Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i+1))) {
                String s = str2.substring(i, i+2);
                
                if(map.containsKey(s) && map.get(s) > 0) {
                    map.replace(s, map.get(s)-1);
                    same++;
                }
                
                count2++;
            }
        }
        
        int sum = count1 + count2 - same;
        if(sum == 0) return 65536;
        
        int answer = same * 65536 / sum;
        
        return answer;
    }
}
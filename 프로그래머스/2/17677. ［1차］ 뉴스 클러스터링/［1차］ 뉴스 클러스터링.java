import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map = new HashMap<>();
        int a = 0;
        // StringBuilder sb = new StringBuilder();
        for(int i=0; i<str1.length()-1; i++) {
            if(str1.charAt(i)>='a' && str1.charAt(i)<='z' &&
               str1.charAt(i+1)>='a' && str1.charAt(i+1)<='z') {
                String s = "";
                s += str1.charAt(i);
                s += str1.charAt(i+1);
                a++;
                // sb.append(str1.charAt(i));
                // sb.append(str1.charAt(i+1));
                // String s = sb.toString();
                if(map.containsKey(s)) map.replace(s, map.get(s)+1);
                else map.put(s, 1);
            }
        }
        
        int b = 0;
        int same = 0;
        for(int i=0; i<str2.length()-1; i++) {
            if(str2.charAt(i)>='a' && str2.charAt(i)<='z' &&
               str2.charAt(i+1)>='a' && str2.charAt(i+1)<='z') {
                String s = "";
                s += str2.charAt(i);
                s += str2.charAt(i+1);
                b++;
                if(map.containsKey(s) && map.get(s) > 0) {
                    map.replace(s, map.get(s)-1);
                    same++;
                }
            }
        }
        
        int sum = a + b - same;
        if(sum == 0) return 65536;
        answer = same * 65536 / sum;
        
        return answer;
    }
}
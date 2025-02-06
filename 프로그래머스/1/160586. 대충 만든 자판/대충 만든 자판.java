import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                int count = i+1;
                if(!map.containsKey(c) || map.get(c) > count) map.put(c, count);
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            int sum = 0;
            for(char c : targets[i].toCharArray()) {
                if(map.containsKey(c)) sum += map.get(c);
                else {
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}
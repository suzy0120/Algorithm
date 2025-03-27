import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        int answer = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue()+1);
        }
        
        return answer-1;
    }
}
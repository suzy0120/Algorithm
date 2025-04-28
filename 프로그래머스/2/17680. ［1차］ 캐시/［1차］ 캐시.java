import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        Queue<String> LRU = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if(LRU.contains(city)) {
                LRU.remove(city);
                LRU.add(city);
                answer += 1;
            } else {
                if(LRU.size() >= cacheSize) LRU.poll();
                LRU.add(city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
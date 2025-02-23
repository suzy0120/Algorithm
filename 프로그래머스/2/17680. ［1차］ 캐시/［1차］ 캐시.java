import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        for(int i=0; i<cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        Queue<String> queue = new LinkedList<>();
        for(String city : cities) {
            if(queue.contains(city)) {
                answer++;
                
                queue.remove(city);
                queue.add(city);
            } else {
                answer+=5;
                
                if(queue.size() == cacheSize) queue.poll();
                if(cacheSize > 0) queue.add(city);
            }
        }
        
        return answer;
    }
}
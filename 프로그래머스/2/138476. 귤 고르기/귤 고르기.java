import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) map.replace(tangerine[i], map.get(tangerine[i])+1);
            else map.put(tangerine[i], 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        pq.addAll(map.entrySet());
        
        int count = 0;
        int answer = 0;
        while(count < k) {
            count += pq.poll().getValue();
            answer++;
        }
        
        return answer;
    }
}
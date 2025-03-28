import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>(); // 선입선출
        
        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double) remain/speeds[i]);
            q.add(day);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && cur >= q.peek()) {
                q.poll();
                count++;
            }
            
            list.add(count);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
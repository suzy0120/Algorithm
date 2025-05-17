import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] > 0) day++;
            
            q.add(day);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int baepo = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && baepo>=q.peek()) {
                q.poll();
                count++;
            }
            
            list.add(count);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
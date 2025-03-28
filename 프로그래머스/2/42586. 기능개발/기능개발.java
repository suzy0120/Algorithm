import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>(); // 선입선출
        
        int remainder, day;
        for(int i=0; i<progresses.length; i++) {
            remainder = 100 - progresses[i];
            day = (int) Math.ceil((double) remainder/speeds[i]);
            
            q.add(day);System.out.println(day);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int num = q.poll();
            int count = 1;
            
            while(!q.isEmpty() && num >= q.peek()) {
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
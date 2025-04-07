import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            queue.add(new int[] {i, priorities[i]});
        }
        
        int answer = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            boolean b = true;
            for(int[] q : queue) {
                if(q[1] > cur[1]) {
                    queue.add(cur);
                    b = false;
                    break;
                }
            }
            
            if(b) {
                answer++;
                
                if(cur[0] == location) break;
            }
        }
        
        return answer;
    }
}
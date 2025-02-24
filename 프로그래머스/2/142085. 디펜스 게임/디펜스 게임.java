import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        int total = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<enemy.length; i++) {
            pq.offer(enemy[i]);
            total += enemy[i];
            
            if(total > n) {
                if(k == 0) {
                    answer = i;
                    break;
                }
                k--;
                total -= pq.poll();
            }
        }
        
        return answer;
    }
}
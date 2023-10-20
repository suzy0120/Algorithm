import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = enemy.length;
        
        for(int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            n -= enemy[i];
            if(n < 0) {
                if(k <= 0) {
                    answer = i;
                    break;
                } else {
                    k--;
                    n += pq.poll();
                }
            }
        }
        
        return answer;
    }
}
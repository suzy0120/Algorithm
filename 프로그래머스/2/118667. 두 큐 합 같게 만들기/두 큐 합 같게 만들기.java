import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long totalSum = 0, sum1 = 0, sum2 = 0;
        for(int n : queue1) {
            q1.add(n);
            sum1 += n;
            totalSum += n;
        }
        for(int n : queue2) {
            q2.add(n);
            sum2 += n;
            totalSum += n;
        }
        
        if(totalSum%2 == 1) return -1;
        totalSum /= 2;
        
        int answer = 0, count = queue1.length*3;
        while(sum1 != sum2) {
            if(answer > count || q1.isEmpty() || q2.isEmpty()) return -1;
            
            if(sum1 < totalSum) {
                int val = q2.poll();
                sum2 -= val;
                sum1 += val;
                q1.add(val);
            } else if(sum2 < totalSum) {
                int val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.add(val);
            }
            
            answer++;
        }
        
        return answer;
    }
}
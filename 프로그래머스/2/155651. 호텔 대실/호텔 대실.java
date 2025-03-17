import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] time = new int[book_time.length][2];
        for(int i=0; i<book_time.length; i++) {
            time[i][0] = Integer.parseInt(book_time[i][0].substring(0, 2))*60 + Integer.parseInt(book_time[i][0].substring(3));
            time[i][1] = Integer.parseInt(book_time[i][1].substring(0, 2))*60 + Integer.parseInt(book_time[i][1].substring(3))+10;
        }
        
        Arrays.sort(time, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] t : time) {
            if(!pq.isEmpty() && pq.peek() <= t[0]) pq.poll();
            
            pq.offer(t[1]);
        }
        
        answer = pq.size();
        return answer;
    }
}
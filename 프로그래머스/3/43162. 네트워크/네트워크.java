import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) { 
                BFS(i, visited, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void BFS(int start, boolean[] visited, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int c=0; c<computers.length; c++) {
                if(computers[cur][c]==1 && !visited[c]) {
                    q.add(c);
                    visited[c] = true;
                }
            }
        }
    }
}
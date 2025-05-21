import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        List<int[]>[] adj = new List[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int[] r : road) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        
        pq.offer(new int[]{1, 0});
        
        // 다익스트라
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            
            if(d > dist[node]) continue;
            
            for(int[] next : adj[node]) {
                int nextNode = next[0], time = next[1];
                if(dist[nextNode] > d + time) {
                    dist[nextNode] = d + time;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}
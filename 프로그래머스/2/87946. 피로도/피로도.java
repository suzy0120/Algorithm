class Solution {
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        DFS(k, dungeons, visited, 0);
        
        return answer;
    }
    
    private void DFS(int k, int[][] dungeons, boolean[] visited, int count) {
        answer = Math.max(answer, count);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                DFS(k-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }
    }
}
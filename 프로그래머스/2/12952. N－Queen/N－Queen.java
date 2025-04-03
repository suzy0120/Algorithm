class Solution {
    public int answer;
    
    public int solution(int n) {
        answer = 0;
        int[] row = new int[n];
        
        DFS(0, row, n);
        return answer;
    }
    
    private void DFS(int depth, int[] row, int n) {
        if(depth == n) {
            answer++;
            return;
        }
        
        for(int c=0; c<n; c++) {
            boolean isOk = true;
            
            for(int i=0; i<depth; i++) {
                // 같은 열 또는 대각선에 있으면 안 됨
                if(row[i]==c || Math.abs(depth-i) == Math.abs(c-row[i])) {
                    isOk = false;
                    break;
                }
            }
            
            if(isOk) {
                row[depth] = c;
                DFS(depth+1, row, n);
            }
        }
    }
}
class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int idx = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(c == idx) {
                    answer[r][c] = 1;
                    continue;
                }
                answer[r][c] = 0;
            }
            idx++;
        }
        return answer;
    }
}
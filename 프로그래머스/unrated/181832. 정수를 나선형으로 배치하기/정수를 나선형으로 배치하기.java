class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int idx = 0;
        int count = 1;
        
        if(n == 1) {
            answer[0][0] = 1;
        } else {
            while(count <= (n*n)) {
                for(int j = idx; j < n-idx; j++) { // 행 고정 열 증가
                    answer[idx][j] = count++;
                }
                for(int j = idx+1; j < n-idx; j++) { // 행 증가 열 고정
                    answer[j][n-(idx+1)] = count++;
                }
                for(int j = n-(idx+2); j >= idx; j--) { // 행 고정 열 감소
                    answer[n-(idx+1)][j] = count++;
                }
                for(int j = n-(idx+2); j > idx; j--) { // 행 감소 열 고정
                    answer[j][idx] = count++;
                }
                idx++;
            }
        }
        
        return answer;
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            answer[i] = "";
        }
        
        // arr1 -> 2진수 변환
        int[][] board1 = new int[n][n];
        for(int r=0; r<n; r++) {
            int num = arr1[r];
            int[] remainder = new int[n];
            int idx = 0;
            if(num == 0) {
                for(int c=0; c<n; c++) {
                    board1[r][c] = 0;
                }
            } else {
                while(num > 0) {
                    remainder[idx]= num%2;
                    num/=2;
                    idx++;
                }
                int zero = n-idx;
                for(int c=0; c<zero; c++) {
                    board1[r][c] = 0;
                }
                for(int c=zero; c<n; c++) {
                    board1[r][c] = remainder[--idx];
                }
            }
        }
        
        // arr2 -> 2진수 변환
        int[][] board2 = new int[n][n];
        for(int r=0; r<n; r++) {
            int num = arr2[r];
            int[] remainder = new int[n];
            int idx = 0;
            if(num == 0) {
                for(int c=0; c<n; c++) {
                    board2[r][c] = 0;
                }
            } else {
                while(num > 0) {
                    remainder[idx]= num%2;
                    num/=2;
                    idx++;
                }
                int zero = n-idx;
                for(int c=0; c<zero; c++) {
                    board2[r][c] = 0;
                }
                for(int c=zero; c<n; c++) {
                    board2[r][c] = remainder[--idx];
                }
            }
        }
        
        // 벽이랑 공백 비교
        int[][] map = new int[n][n];
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(board1[r][c] == board2[r][c] && board1[r][c] == 0) map[r][c]=0;
                else map[r][c]=1;
            }
        }
        
        // 벽이면 # 공백이면 '빈칸'
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(map[r][c]==0) answer[r] += " ";
                else answer[r] += "#";
            }
        }
        
        return answer;
    }
}
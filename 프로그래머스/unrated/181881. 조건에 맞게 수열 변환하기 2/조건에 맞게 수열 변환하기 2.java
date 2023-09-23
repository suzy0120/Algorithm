class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int[][] copy = new int[10][arr.length];
        
        for(int c = 0; c < arr.length; c++) {
            copy[0][c] = arr[c];
        }
        
        loop: for(int r = 1; r < 10; r++) {
            for(int c = 0; c < arr.length; c++) {
                if(50 <= copy[r-1][c] && copy[r-1][c] % 2 == 0) {
                    copy[r][c] = copy[r-1][c] / 2;
                } else if(copy[r-1][c] < 50 && copy[r-1][c] % 2 == 1) {
                    copy[r][c] = copy[r-1][c] * 2 + 1;
                } else {
                    copy[r][c] = copy[r-1][c];
                }
            }
            
            int count = 0;
            
            for(int c = 0; c < arr.length; c++) {
                if(copy[r-1][c] == copy[r][c]) count++;
                if(count == arr.length) {
                    answer = r-1;
                    break loop;
                }
            }
        }
        
        return answer;
    }
}
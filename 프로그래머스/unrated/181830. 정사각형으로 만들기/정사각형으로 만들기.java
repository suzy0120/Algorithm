class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        int max = Math.max(arr.length, arr[0].length);
        if(max == arr.length) {
            answer = new int[arr.length][arr.length];
        } else {
            answer = new int[arr[0].length][arr[0].length];
        }
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0; c < arr[0].length; c++) {
                answer[r][c] = arr[r][c];
            }
        }
        return answer;
    }
}
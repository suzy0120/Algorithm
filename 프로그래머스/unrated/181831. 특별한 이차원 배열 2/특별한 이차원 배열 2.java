class Solution {
    public int solution(int[][] arr) {
        int answer = 0;
        loop : for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[i][j] != arr[j][i]) {
                    break loop;
                }
            }
            answer = 1;
        }
        return answer;
    }
}
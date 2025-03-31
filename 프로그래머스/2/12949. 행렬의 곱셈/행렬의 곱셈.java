class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        // m*k * k*n --> m*n
        int[][] answer = new int[arr1.length][arr2[0].length];
        // System.out.println(answer.length); // 3
        // System.out.println(answer[0].length); // 2
        
        // i : answer.length == 3
        // j : answer[0].length == 2
        // k : arr2.length == 2
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                int sum = 0;
                for(int k = 0; k < arr2.length; k++){
                    sum += arr1[i][k] * arr2[k][j];
                    //System.out.println("i : " + i + "  j : " + j + "  k : " + k + "  sum : " + sum);
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int n = 0;
        for(int i = 0; i < num_list.length; i++) {
            n = num_list[i];
            while(n > 1) {
                if(n % 2 == 0) {
                    answer++;
                    n /= 2;
                } else {
                    answer++;
                    n = (n-1) / 2;
                }
            }
        }
        return answer;
    }
}
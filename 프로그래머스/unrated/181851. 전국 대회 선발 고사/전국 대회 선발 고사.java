class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] arr = new int[3];
        int idx = 0;
        int n = 1;
        while(idx < 3) {
            for(int j = 0; j < rank.length; j++) {
                if(rank[j] == n && attendance[j]) {
                    arr[idx++] = j;
                    n++;
                } else if(rank[j] == n && !attendance[j]) {
                    n++;
                }
                if(idx == 3) break;
            }
        }
        answer = 10000 * arr[0] + 100 * arr[1] + arr[2];
        return answer;
    }
}
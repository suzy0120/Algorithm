class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left=0, right=0;
        int sum = sequence[0];
        int minLen = Integer.MAX_VALUE;
        
        while(right < sequence.length) {
            if(sum == k) {
                int len = right - left + 1;
                if(len < minLen) {
                    minLen = len;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            
            if(sum <= k) {
                right++;
                if(right < sequence.length) sum += sequence[right];
            } else {
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}
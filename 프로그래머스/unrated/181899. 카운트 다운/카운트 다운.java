class Solution {
    public int[] solution(int start, int end_num) {
        int[] answer = new int[start - end_num + 1];
        int idx = 0;
        int i = start;
        while(i > end_num - 1) {
            answer[idx++] = i--;
        }
        return answer;
    }
}
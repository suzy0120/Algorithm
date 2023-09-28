class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] count = new int[31];
        for(int i = 0; i < strArr.length; i++) {
            count[strArr[i].length()]++;
        }
        int max = -1;
        for(int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
            answer = max;
        }
        return answer;
    }
}
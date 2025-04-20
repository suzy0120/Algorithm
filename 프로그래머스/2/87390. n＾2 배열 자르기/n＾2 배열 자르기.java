class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        for(int i=0; i<answer.length; i++) {
            long idx = left + i;
            int r = (int)(idx/n);
            int c = (int)(idx%n);
            answer[i] = Math.max(r, c) + 1;
        }
        
        return answer;
    }
}
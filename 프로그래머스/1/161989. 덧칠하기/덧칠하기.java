class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int position = 0;
        
        for(int sec : section) {
            if(position <= sec) {
                position = sec+m;
                answer++;
            }
        }
        
        return answer;
    }
}
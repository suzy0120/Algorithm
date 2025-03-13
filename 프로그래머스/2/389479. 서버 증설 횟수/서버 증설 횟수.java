class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] count = new int[24];
        
        for(int i=0; i<players.length; i++) {
            int server = players[i]/m;
            
            if(server > count[i]) {
                int diff = server - count[i];
                answer += diff;
                
                int end = Math.min(i+k, players.length);
                for(int j=i; j<end; j++) {
                    count[j] += diff;
                }
            }
        }
        
        return answer;
    }
}
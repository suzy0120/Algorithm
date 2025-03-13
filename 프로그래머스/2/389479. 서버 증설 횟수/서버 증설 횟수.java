class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] count = new int[24];
        
        for(int i=0; i<players.length; i++) {
            int server = players[i]/m;
            
            if(server > 0) {
                int len = i+k-1 < players.length ? i+k : players.length;
                
                if(server > count[i]) {
                    int increase = count[i];
                    answer += (server-increase);
                    
                    for(int j=i; j<len; j++) {
                        count[j] += (server-increase);
                    }
                }
            }
        }
        
        return answer;
    }
}
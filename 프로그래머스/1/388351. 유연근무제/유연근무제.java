class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            int succession = 0;
            int hour = schedules[i]+10;
            if(hour%100 > 59) hour = ((hour/100+1)*100) + ((hour%100)-60);
            
            for(int j=0; j<7; j++) {
                if(startday == 1) {
                    if(j==5) break;
                } else if(startday == 2) {
                    if(j==4 || j==5) continue; 
                } else if(startday == 3) {
                    if(j==3 || j==4) continue; 
                } else if(startday == 4) {
                    if(j==2 || j==3) continue; 
                } else if(startday == 5) {
                    if(j==1 || j==2) continue; 
                } else if(startday == 6) {
                    if(j==0 || j==1) continue; 
                } else {
                    if(j==6 || j==0) continue; 
                }
                
                if((hour) >= timelogs[i][j]) succession++;
            }
            
            if(succession == 5) answer++;
        }
        
        return answer;
    }
}
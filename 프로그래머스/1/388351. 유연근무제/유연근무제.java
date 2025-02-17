class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = 0;
        
        int[] validDays = getValidDays(startday);
        
        for(int i=0; i<n; i++) {
            int time = schedules[i];
            int hour = time/100;
            int minute = time%100 + 10;
            if(minute > 59) {
                hour += 1;
                minute -= 60;
            }
            time = hour*100 + minute;
            
            boolean qualifies = true;
            for(int day : validDays) {
                if(time < timelogs[i][day]) {
                    qualifies = false;
                    break;
                }
            }
            
            if(qualifies) answer++;
        }
        
        return answer;
    }
    
    private int[] getValidDays(int startday) {
        switch(startday) {
            case 1: return new int[]{0, 1, 2, 3, 4};
            case 2: return new int[]{0, 1, 2, 3, 6};
            case 3: return new int[]{0, 1, 2, 5, 6};
            case 4: return new int[]{0, 1, 4, 5, 6};
            case 5: return new int[]{0, 3, 4, 5, 6};
            case 6: return new int[]{2, 3, 4, 5, 6};
            case 7: return new int[]{1, 2, 3, 4, 5};
            default: return new int[]{};
        }
    }
}
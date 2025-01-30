class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int zero = 0;
        
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) zero++;
        }
        
        for(int i=0; i<win_nums.length; i++) {
            for(int j=0; j<lottos.length; j++) {
                if(win_nums[i] == lottos[j]) {
                    count++;
                    break;
                }
            }
        }
        
        switch(count) {
            case 0:
                answer[1]=6; 
                break;
            case 1:
                answer[1]=6;
                break;
            case 2:
                answer[1]=5;
                break;
            case 3:
                answer[1]=4;
                break;
            case 4:
                answer[1]=3;
                break;
            case 5:
                answer[1]=2;
                break;
            case 6:
                answer[1]=1;
                break;
        }
        
        answer[0] = answer[1] - zero;
        if(zero == 6) answer[0] = 1;
        
        return answer;
    }
}
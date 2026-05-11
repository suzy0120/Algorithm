class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6, 6, 5, 4, 3, 2, 1};
        
        int zero = 0, cnt = 0;
        for(int l : lottos) {
            if(l == 0) zero++;
            else {
                for(int n : win_nums) {
                    if(l == n) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        
        return new int[]{answer[cnt + zero], answer[cnt]};
    }
}
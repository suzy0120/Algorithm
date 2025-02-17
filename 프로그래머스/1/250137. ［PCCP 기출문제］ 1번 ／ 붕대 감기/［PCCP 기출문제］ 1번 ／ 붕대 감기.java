class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int current = health;
        int succession = 0;
        
        loop: for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            boolean attack = true;
            
            // 공격을 당하면
            for(int j=0; j<attacks.length; j++) {
                if(i==attacks[j][0]) {
                    current -= attacks[j][1];
                    
                    if(current <= 0) { // 죽는다면
                        answer = -1;
                        break loop;
                    }
                    
                    succession = 0;
                    attack = false;
                    break;
                }
            }
            
            // 공격을 안 당하면
            if(attack) {
                succession++;
                if(succession == bandage[0]) {
                    current += bandage[2];
                    succession = 0;
                }
                
                current = ((current + bandage[1]) > health) ? health : (current + bandage[1]);
            }
        }
        
        if(answer != -1) answer = current;
        return answer;
    }
}
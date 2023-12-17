class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int idx = 0;
        int count = 0;
        int max = health;
        
        for(int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            if(i == attacks[idx][0]) { // 공격 받을 때
                health = health - attacks[idx][1];
                if(health <= 0) { // 캐릭터의 체력이 0 이하가 될 때
                    break;
                }
                count = 0;
                idx++;
            } else { // 공격 받지 않을 때
                health = health + bandage[1];
                count++;
                if(health > max) { // 최대 체력보다 커질 때
                    health = max;
                }
                if(count == bandage[0]) { // 연속으로 붕대를 감는 데 성공
                    health = health + bandage[2];
                    count = 0;
                }
            }
        }
        
        answer = (health <= 0 ? -1 : health);
        return answer;
    }
}
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        
        for(int i = ((max+1)-min); i <= max; i++) { // 가장 긴 변이 주어진 경우
            answer++;
        }
        for(int i = max+1; i < (max+min); i++) { // 나머지 한 변이 가장 긴 변인 경우
            answer++;
        }
        
        return answer;
    }
}
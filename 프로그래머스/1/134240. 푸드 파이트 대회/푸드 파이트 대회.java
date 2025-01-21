class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++) {
            if(food[i] == 1) continue;
            for(int j=0; j<food[i]/2; j++) {
                answer += i;
            }
        }
        
        answer += 0;
        
        String copy = answer;
        for(int i=answer.length()-2; i>=0; i--) {
            answer += copy.charAt(i);
        }
        
        return answer;
    }
}
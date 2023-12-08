class Solution {
    public int solution(int[] numbers) {
        int answer = Integer.MIN_VALUE;
        int mult = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                mult = numbers[i] * numbers[j];
                answer = Math.max(answer, mult);
            }
        }
        
        return answer;
    }
}
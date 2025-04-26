class Solution {
    
    public static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int i, int sum) {
        if(i == numbers.length) {
            if(sum == target) {
                answer++;
            }
            
            return;
        }
        
        DFS(numbers, target, i+1, sum+numbers[i]);
        DFS(numbers, target, i+1, sum-numbers[i]);
    }
}
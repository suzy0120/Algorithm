class Solution {
    public String solution(String s) {
        String[] num = s.split(" ");
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String n : num) {
            min = Math.min(min, Integer.parseInt(n));
            max = Math.max(max, Integer.parseInt(n));
        }
        
        String answer = min + " " + max;
        return answer;
    }
}
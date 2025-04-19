class Solution {
    public String solution(String s) {
        String[] num = s.split(" ");
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<num.length; i++) {
            min = Math.min(min, Integer.parseInt(num[i]));
            max = Math.max(max, Integer.parseInt(num[i]));
        }
        
        String answer = min + " " + max;
        return answer;
    }
}
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] num = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String n : num) {
            if(max < Integer.parseInt(n)) max = Integer.parseInt(n);
            if(min > Integer.parseInt(n)) min = Integer.parseInt(n);
        }
        
        answer += min + " " + max;
        
        return answer;
    }
}
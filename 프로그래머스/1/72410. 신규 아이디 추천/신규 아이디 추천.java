class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9_.-]", "");
        
        answer = answer.replaceAll("([.])\\1+", "$1");
        
        answer = answer.replaceAll("^[.]+|[.]+$", "");
        
        answer = (answer.length() == 0) ? "a" : answer;
        
        answer = (answer.length() >= 16 ? answer.substring(0, 15) : answer).replaceAll("[.]+$", "");
        
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length()-1);
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        for(String[] ip : db) {
            if(id_pw[0].equals(ip[0])) {
                if(id_pw[1].equals(ip[1])) {
                    answer = "login";
                    break;
                } else answer = "wrong pw";
            }
        }
        
        if(answer.equals("")) answer = "fail";
        
        return answer;
    }
}
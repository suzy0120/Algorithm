class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String s : babbling) {
            if(s.contains("ayaaya") || s.contains("yeye") ||
               s.contains("woowoo") || s.contains("mama")) continue;
            
            for(String word : words) {
                s=s.replace(word, " ");
            }
            
            s=s.replace(" ", "");
            if(s.equals("")) answer++;
        }
        
        return answer;
    }
}
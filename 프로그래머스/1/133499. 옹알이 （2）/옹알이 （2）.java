class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        
        for(String b : babbling) {
            if(b.contains("ayaaya") || b.contains("yeye") ||
               b.contains("woowoo") || b.contains("mama")) continue;
            
            String temp = b;
            for(String word : words)
                temp = temp.replace(word, " ");
            
            temp = temp.replace(" ", "");
            if(temp.equals("")) answer++;
        }
        
        return answer;
    }
}
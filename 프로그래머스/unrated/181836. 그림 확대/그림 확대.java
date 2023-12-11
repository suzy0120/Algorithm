class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;
        
        for(int i = 0; i < picture.length; i++) {
            String s = "";
            
            for(int j = 0; j < picture[i].length(); j++) { // 가로 늘이기
                for(int c = 1; c <= k; c++) {
                    s += picture[i].charAt(j);
                }
            }
            
            for(int r = 1; r <= k; r++) { // 세로 늘이기
                answer[idx++] = s; 
            }
        }
        
        return answer;
    }
}
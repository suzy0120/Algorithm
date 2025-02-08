class Solution {
    public String solution(String X, String Y) {
        int[] numX = new int[10];
        int[] numY = new int[10];
        for(char c : X.toCharArray()) numX[c-'0']++;
        for(char c : Y.toCharArray()) numY[c-'0']++;
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            int count = Math.min(numX[i], numY[i]);
            for(int j=0; j<count; j++) {
                sb.append(i);
            }
        }
        
        String answer = "";
        if(sb.length()==0) answer = "-1";
        else if(sb.charAt(0)=='0') answer = "0";
        else answer = sb.toString();
        
        return answer;
    }
}
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        while(sb.length() < m*t) {
            sb.append(Integer.toString(num++, n).toUpperCase());
        }
        
        String answer = "";
        for(int i=p-1; i<m*t; i+=m) {
            answer += sb.charAt(i);
        }
        
        return answer;
    }
}
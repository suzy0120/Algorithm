class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        Long num = Long.parseLong(p);
        int m = t.length()-p.length();
        
        for(int i=0; i<=m; i++) {
            Long cut = Long.parseLong(t.substring(i, i+p.length()));
            if(cut <= num) answer++;
        }
        
        return answer;
    }
}
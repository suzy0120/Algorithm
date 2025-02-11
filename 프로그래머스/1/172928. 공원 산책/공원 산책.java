class Solution {
    public int[] solution(String[] park, String[] routes) {
        int nr = 0;
        int nc = 0;
        for(int r=0; r<park.length; r++) {
            for(int c=0; c<park[0].length(); c++) {
                if(park[r].charAt(c)=='S') {
                    nr=r;
                    nc=c;
                }
            }
        }
        
        int dr = nr;
        int dc = nc;
        int N = park.length;
        int M = park[0].length();
        for(String s : routes) {
            int r = dr;
            int c = dc;
            int count = s.charAt(2)-'0';
            for(int d=1; d<=count; d++) {
                if(s.charAt(0)=='N') dr--;
                else if(s.charAt(0)=='S') dr++;
                else if(s.charAt(0)=='W') dc--;
                else if(s.charAt(0)=='E') dc++;
                
                if(0>dr || dr>=N || 0>dc || dc>=M || park[dr].charAt(dc)=='X') {
                    dr = r;
                    dc = c;
                    break;
                }
            }
        }
        
        int[] answer = {dr, dc};
        return answer;
    }
}
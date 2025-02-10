class Solution {
    public int[] solution(String[] wallpaper) {
        int minR, minC, maxR, maxC = 0;
        minR = minC = Integer.MAX_VALUE;
        maxR = maxC = Integer.MIN_VALUE;
        
        for(int r=0; r<wallpaper.length; r++) {
            for(int c=0; c<wallpaper[r].length(); c++) {
                if(wallpaper[r].charAt(c)=='#') {
                    minR = Math.min(r, minR);
                    minC = Math.min(c, minC);
                    maxR = Math.max(r, maxR);
                    maxC = Math.max(c, maxC);
                }
            }
        }
        
        int[] answer = {minR, minC, maxR+1, maxC+1};
        return answer;
    }
}
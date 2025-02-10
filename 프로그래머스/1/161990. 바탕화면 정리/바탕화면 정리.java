import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        List<int[]> list = new ArrayList<>();
        for(int r=0; r<wallpaper.length; r++) {
            for(int c=0; c<wallpaper[r].length(); c++) {
                if(wallpaper[r].charAt(c)=='#') {
                    list.add(new int[]{r, c});
                }
            }
        }
        
        int[] answer = new int[4];
        int minR = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxC = Integer.MIN_VALUE;
        int indexMinR = 0;
        int indexMaxR = 0;
        int indexMinC = 0;
        int indexMaxC = 0;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i)[0]<minR) {
                minR = list.get(i)[0];
                indexMinR = i;
            }
            if(list.get(i)[0]>maxR) {
                maxR = list.get(i)[0];
                indexMaxR = i;
            }
            if(list.get(i)[1]<minC) {
                minC = list.get(i)[1];
                indexMinC = i;
            }
            if(list.get(i)[1]>maxC) {
                maxC = list.get(i)[1];
                indexMaxC = i;
            }
        }
        
        if(indexMinR==indexMinC) {
            answer[0] = list.get(indexMinR)[0];
            answer[1] = list.get(indexMinR)[1];
        } else {
            answer[0] = list.get(indexMinR)[0];
            answer[1] = list.get(indexMinC)[1];
        }
        if(indexMaxR==indexMaxC) {
            answer[2] = list.get(indexMaxR)[0]+1;
            answer[3] = list.get(indexMaxR)[1]+1;
        } else {
            answer[2] = list.get(indexMaxR)[0]+1;
            answer[3] = list.get(indexMaxC)[1]+1;
        }
        
        return answer;
    }
}
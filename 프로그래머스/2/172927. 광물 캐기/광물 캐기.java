import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int total = picks[0] + picks[1] + picks[2];
        
        List<int[]> list = new ArrayList<>();
        
        for(int i=0; i<minerals.length && list.size()<total; i+=5) {
            int dia=0, iron=0, stone=0;
            
            for(int j=i; j<i+5 && j<minerals.length; j++) {
                if(minerals[j].equals("diamond")) {
                    dia+=1;
                    iron+=5;
                    stone+=25;
                } else if(minerals[j].equals("iron")) {
                    dia+=1;
                    iron+=1;
                    stone+=5;
                } else {
                    dia+=1;
                    iron+=1;
                    stone+=1;
                }
            }
            
            list.add(new int[] {dia, iron, stone});
        }
        
        list.sort((a, b) -> b[2] - a[2]);
        
        int answer = 0;
        for(int i=0; i<list.size(); i++) {
            int[] group = list.get(i);
            
            if(picks[0] > 0) {
                answer += group[0];
                picks[0]--;
            } else if(picks[1] > 0) {
                answer += group[1];
                picks[1]--;
            } else if(picks[2] > 0) {
                answer += group[2];
                picks[2]--;
            } else break;
        }
        
        return answer;
    }
}
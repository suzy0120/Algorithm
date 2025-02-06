import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> map = new LinkedHashMap<>();
        
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i);
        }
        
        // 누가 누구한테 주고받았는지
        int[][] score = new int[friends.length][friends.length];
        for(String gift : gifts) {
            String[] name = gift.split(" ");
            String giver = name[0];
            String recevier = name[1];
            int r = map.get(giver);
            int c = map.get(recevier);
            score[r][c]++;
        }
        
        // 각자 준 선물, 받은 선물
        int[] givenCount = new int[friends.length];
        int[] receivedCount = new int[friends.length];
        for(int r=0; r<score.length; r++) {
            for(int c=0; c<score.length; c++) {
                givenCount[r] += score[r][c];
                receivedCount[c] += score[r][c];
            }
        }
        
        // 선물 지수
        int[] point = new int[friends.length];
        for(int i=0; i<friends.length; i++) {
            point[i] = givenCount[i] - receivedCount[i];
        }
        
        // 다음달 선물 예측
        int[] prediction = new int[friends.length];
        for(int r=0; r<score.length; r++) {
            for(int c=r+1; c<score.length; c++) {
                if(score[r][c] > score[c][r]) prediction[r]++;
                else if(score[r][c] < score[c][r]) prediction[c]++;
                else {
                    if(point[r] > point[c]) prediction[r]++;
                    else if(point[r] < point[c]) prediction[c]++;
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<prediction.length; i++) {
            max = max < prediction[i] ? prediction[i] : max;
        }
        answer = max;
        
        return answer;
    }
}
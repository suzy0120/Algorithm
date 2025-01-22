class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<goal.length; i++) {
            if(goal[i].equals(cards1[cnt1])) {
                if(cnt1 < cards1.length-1) cnt1++;
            } else if(goal[i].equals(cards2[cnt2])) {
                if(cnt2 < cards2.length-1) cnt2++;
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}
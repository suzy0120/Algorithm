import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++) {
            String str = String.valueOf(i);
            boolean flag = true;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '0' || str.charAt(j) == '5') {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(i);
            }
        }
        int[] answer;
        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }
}
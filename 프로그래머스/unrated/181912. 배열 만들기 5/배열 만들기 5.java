import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < intStrs.length; i++) {
            String str = "";
            for(int j = s; j < s+l; j++) {
                str += intStrs[i].charAt(j);
            }
            if(k < Integer.parseInt(str)) {
                list.add(Integer.valueOf(str));
            }
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
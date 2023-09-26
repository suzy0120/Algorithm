import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        String[] answer = myStr.split("a|b|c");
        for(int i = 0; i < answer.length; i++) {
            if(!answer[i].equals("")) {
                list.add(answer[i]);
            }
        }
        if(list.size() == 0) {
            answer = new String[1];
            answer[0] = "EMPTY";
        } else {
            answer = new String[list.size()];
        }
        int idx = 0;
        for (String s : list) {
            answer[idx++] = s;
        }
        return answer;
    }
}
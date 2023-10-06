import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        ArrayList<String> list = new ArrayList<>();
        String cut = "";
        for(int i = 0; i < my_str.length(); i+=n) {
            if(my_str.length()-i < n) {
                cut = my_str.substring(i, my_str.length());
                list.add(cut);
                break;
            }
            cut = my_str.substring(i, i+n);
            list.add(cut);
        }
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String s : list) {
            answer[idx++] = s;
        }
        return answer;
    }
}
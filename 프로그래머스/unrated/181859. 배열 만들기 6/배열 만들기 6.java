import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(list.size() == 0) {
                list.add(arr[i]);
            } else if(arr[i] == list.get(list.size()-1)) {
                list.remove(list.size()-1);
            } else {
                list.add(arr[i]);
            }
        }
        int[] answer = new int[list.size()];
        if(list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        int idx = 0;
        for(int n : list) {
            answer[idx++] = n;
        }
        return answer;
    }
}
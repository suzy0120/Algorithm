import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < flag.length; i++) {
            if(flag[i]) {
                int plus = arr[i]*2;
                for(int j = 0; j < plus; j++) {
                    list.add(arr[i]);
                }
            } else {
                int minus = arr[i];
                for(int j = 0; j < minus; j++) {
                    list.remove(list.size()-1);
                }
            }
        }
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int n : list) {
            answer[idx++] = n;
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            for(int j = 0; j < delete_list.length; j++) {
                if(arr[i] == delete_list[j]) {
                    break;
                }
                count++;
            }
            if(count == delete_list.length) {
                list.add(arr[i]);
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
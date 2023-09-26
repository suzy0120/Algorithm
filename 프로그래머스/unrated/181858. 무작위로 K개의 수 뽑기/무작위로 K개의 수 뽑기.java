import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            boolean check = false;
            for(int j = 0; j < list.size(); j++) {
                if(arr[i] == list.get(j)) check = true;
            }
            if(!check) list.add(arr[i]);
            if(list.size() == k) break;
            
        }
        if(list.size() < k) {
            int size = list.size();
            for(int i = 0; i < k-size; i++) {
                list.add(-1);
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
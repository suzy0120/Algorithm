import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int n = 0; n <= 10; n++) {
            if(arr.length == Math.pow(2, n)) {
                for(int i = 0; i < arr.length; i++) {
                    list.add(arr[i]);
                }
                break;
            } else if (arr.length < Math.pow(2, n)) {
                for(int i = 0; i < arr.length; i++) {
                    list.add(arr[i]);
                }
                for(int i = arr.length; i < Math.pow(2, n); i++) {
                    list.add(0);
                }
                break;
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
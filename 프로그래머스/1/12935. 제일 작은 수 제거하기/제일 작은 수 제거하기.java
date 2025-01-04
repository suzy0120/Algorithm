import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(arr.length == 1) return new int[]{-1};
        else {
            for(int num : arr) list.add(num);
        }
        
        list.remove(Collections.min(list));
        
        int[] answer = new int[arr.length-1];
        for(int i=0; i<answer.length; i++) answer[i]=list.get(i);
        
        return answer;
    }
}
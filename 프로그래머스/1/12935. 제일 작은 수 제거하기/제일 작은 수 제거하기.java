import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        for(int num : arr) {
            if(num < min) {
                min = num;
            }
        }
        
        for(int num : arr) {
            if(min != num) {
                list.add(num);
            }
        }
        
        
        if(list.isEmpty()) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) answer[i]=list.get(i);
        
        return answer;
    }
}
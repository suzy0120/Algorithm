import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> element = new ArrayList<>();
        
        for(int num : arr) {
            if(num%divisor==0) {
                element.add(num);
            }
        }
        
        if(element.isEmpty()) return new int[]{-1};
        
        Collections.sort(element);
        
        int[] answer = new int[element.size()];
        for(int i=0; i<answer.length; i++) answer[i] = element.get(i);
            
        return answer;
    }
}
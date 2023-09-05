import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        int[] minus = new int[array.length];
        int answer = 0;
        
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++){
            minus[i] = Math.abs(array[i]-n);
        }
        
        int min = minus[0];
        int minIdx = 0;
        
        for(int i=0; i<array.length; i++) {
            if (minus[i] < min) {
                minIdx = i;
                min = minus[i];
            }
        }
        
        answer = array[minIdx];
        
        return answer;
    }
}
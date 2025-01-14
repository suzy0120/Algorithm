import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int num = 0;
        
        for(int[] list : commands) {
            int[] copy = new int[list[1]-list[0]+1];
            int idx = 0;
            for(int i=list[0]-1; i<list[1]; i++) {
                copy[idx++] = array[i];
            }
            Arrays.sort(copy);
            answer[num++] = copy[list[2]-1];
        }
        
        return answer;
    }
}
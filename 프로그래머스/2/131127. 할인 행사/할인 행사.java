import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int start = 0; start <= discount.length - 10; start++) {
            int[] tempNumber = Arrays.copyOf(number, number.length);
            int count = 0;

            for (int i = start; i < start + 10; i++) {
                for(int j = 0; j < want.length; j++) {
                    if(discount[i].equals(want[j]) && tempNumber[j] > 0) {
                        tempNumber[j]--;
                        
                        if(tempNumber[j] == 0) count++;
                        break;
                    }
                }
            }
            
            if(count == want.length) answer++;
        }
        
        return answer;
    }
}
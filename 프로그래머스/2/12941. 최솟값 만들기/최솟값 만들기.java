import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Integer[] C = new Integer[B.length];
        for(int i=0; i<B.length; i++) {
            C[i] = B[i];
        }
        Arrays.sort(C, Collections.reverseOrder());
        
        int answer = 0;
        for(int i=0; i<A.length; i++) {
            for(int j=i; j<B.length; j++) {
                answer += A[i] * C[j];
                break;
            }
        }

        return answer;
    }
}
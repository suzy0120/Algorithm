class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int gcdA = arrayA[0];
        for(int i=1; i<arrayA.length; i++) {
            gcdA = GCD(gcdA, arrayA[i]);
        }
        
        int gcdB = arrayB[0];
        for(int i=1; i<arrayB.length; i++) {
            gcdB = GCD(gcdB, arrayB[i]);
        }
        
        boolean A = true;
        for(int num : arrayB) {
            if(num%gcdA == 0) {
                A = false;
                break;
            }
        }
        
        boolean B = true;
        for(int num : arrayA) {
            if(num%gcdB == 0) {
                B = false;
                break;
            }
        }
        
        if(A) answer = Math.max(answer, gcdA);
        if(B) answer = Math.max(answer, gcdB);
        
        return answer;
    }
    
    private int GCD(int a, int b) {
        return b==0 ? a : GCD(b, a%b);
    }
}
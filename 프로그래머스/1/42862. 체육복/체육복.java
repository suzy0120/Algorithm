import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniforms = new int[n+1];
        
        Arrays.fill(uniforms, 1);
        
        for(int l : lost) uniforms[l]--;
        for(int r : reserve) uniforms[r]++;
        
        for(int i=1; i<=n; i++) {
            if(uniforms[i]==0) {
                if((i-1)>0 && uniforms[i-1]==2) {
                    uniforms[i-1]--;
                    uniforms[i]++;
                } else if((i+1)<=n && uniforms[i+1]==2) {
                    uniforms[i+1]--;
                    uniforms[i]++;
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(uniforms[i] > 0) answer++;
        }
        
        return answer;
    }
}
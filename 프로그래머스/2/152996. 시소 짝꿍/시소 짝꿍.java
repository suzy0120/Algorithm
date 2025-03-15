class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] count = new int[1001];
        
        for(int w : weights) {
            count[w]++;
        }
        
        for(int i=0; i<count.length; i++) {
            if(count[i] == 0) continue;
            
            if(count[i] > 1) answer += (long) count[i] * (count[i]-1) / 2;
            
            if(i*3%2 == 0) {
                int another1 = i*3/2;
                if(another1 < count.length) answer += (long) count[i] * count[another1];
            }
            
            if(i*4%2 == 0) {
                int another2 = i*4/2;
                if(another2 < count.length) answer += (long) count[i] * count[another2];
            }
            
            if(i*4%3 == 0) {
                int another3 = i*4/3;
                if(another3 < count.length) answer += (long) count[i] * count[another3];
            }
        }
        
        return answer;
    }
}
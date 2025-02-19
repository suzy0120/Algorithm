class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int pos1 = a;
        int pos2 = b;
        
        while(pos1 != pos2) {
            if(pos1%2 == 0) pos1 /= 2;
            else pos1 = pos1/2 + 1;
            
            if(pos2%2 == 0) pos2 /= 2;
            else pos2 = pos2/2 + 1;
            
            answer++;
        }
        
        return answer;
    }
}
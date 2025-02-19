class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int pos1 = a;
        int pos2 = b;
        
        while(pos1 != pos2) {
            pos1 = (pos1/2) + (pos1%2);
            pos2 = (pos2/2) + (pos2%2);
            
            answer++;
        }
        
        return answer;
    }
}
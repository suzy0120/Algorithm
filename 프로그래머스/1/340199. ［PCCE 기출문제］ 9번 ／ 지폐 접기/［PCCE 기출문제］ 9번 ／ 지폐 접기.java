class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int wMax = Math.max(wallet[0], wallet[1]);
        int wMin = Math.min(wallet[0], wallet[1]);
        int bMax = Math.max(bill[0], bill[1]);
        int bMin = Math.min(bill[0], bill[1]);
        
        while(bMin > wMin || bMax > wMax) {
            bMax /= 2;
            
            int tempMax = Math.max(bMax, bMin);
            int tempMin = Math.min(bMax, bMin);
            bMax = tempMax;
            bMin = tempMin;
            
            answer++;
        }
        
        return answer;
    }
}
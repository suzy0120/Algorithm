class Solution {
    public static int[] fibo;
    
    public int solution(int n) {
        fibo = new int[n+1];
        DFS(n);
        
        int answer = DFS(n);
        return answer;
    }
    
    public int DFS(int num) {
        if(fibo[num] > 0) return fibo[num];
        
        if(num == 1) return fibo[num]=1;
        else if(num == 2) return fibo[num]=1;
        else return fibo[num] = (DFS(num-2) + DFS(num-1)) % 1234567;
    }
}
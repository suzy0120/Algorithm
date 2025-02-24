class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int nq = n/w;
        int nr = n%w;
        int pq = num/w;
        int pr = num%w;
        
        if(pr == 0) { // w의 배수
            pq-=1;
            pr=w;
        }
        
        if((nq%2==1 && pq%2==1) || (nq%2==0 && pq%2==0)) {
            if(nr >= pr) answer = nq - pq + 1;
            else answer = nq - pq;
        } else if(nq%2==1 && pq%2==0) {
            if(w-nr > pr-1) answer = nq - pq;
            else answer = nq - pq + 1;
        } else if((nq%2==0 && pq%2==1)) {
            if(nr-1 >= w-pr) answer = nq - pq + 1;
            else answer = nq - pq;
        }
        
        return answer;
    }
}
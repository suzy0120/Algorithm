class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] nArr = new int[number];
        
        for(int i=0; i<number; i++) {
            int count = 0;
            for (int j = 1; j * j <= i + 1; j++) {
                if ((i + 1) % j == 0) {
                    count++; // 작은 약수
                    if (j != (i + 1) / j) count++; // 대칭 약수
                }
            }
            if(count <= limit) nArr[i] = count;
            else nArr[i] = power;
        }
        
        for(int n : nArr) answer += n;
        
        return answer;
    }
}
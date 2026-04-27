import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] count = new int[N + 2];
        for(int n : stages) {
            count[n]++;
        }
        
        List<double[]> list = new ArrayList<>();
        double total = stages.length;
        for(int i=1; i<N+1; i++) {
            double failure = (total > 0) ? count[i] / total : 0.0;
            list.add(new double[]{i, failure});
            
            total -= count[i];
        }
        
        Collections.sort(list, (a, b) -> {
            if(Double.compare(b[1], a[1]) == 0) { // 실패율이 같으면
                return Double.compare(a[0], b[0]); // 번호 오름차순
            }
            return Double.compare(b[1], a[1]); // 실패율 기준 내림차순
        });
        
        for(int i=0; i<N; i++) {
            answer[i] = (int) list.get(i)[0];
        }
        return answer;
    }
}
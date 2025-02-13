import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] count = new int[N+2];
        for(int stage : stages) {
            count[stage]++;
        }
        
        Map<Integer, Double> map = new HashMap<>();
        int players = stages.length;
        for(int i=1; i<=N; i++) {
            if(count[i]==0) map.put(i, 0.0);
            else {
                map.put(i, (double) count[i]/players);
                players -= count[i];
            }
        }System.out.println(map);
        
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
                int cmp = Double.compare(e2.getValue(), e1.getValue());
                if(cmp == 0) {
                    return Integer.compare(e1.getKey(), e2.getKey());
                }
                return cmp;
            }
        });
        
        int[] answer = new int[N];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i).getKey();
        }
        return answer;
    }
}
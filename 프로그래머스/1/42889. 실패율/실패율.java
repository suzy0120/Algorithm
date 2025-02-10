import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1. 각 스테이지(1~N+1)에서 머물고 있는 플레이어 수를 카운트
        int[] count = new int[N + 2];
        for (int stage : stages) {
            count[stage]++;
        }
        
        // 2. 각 스테이지(1~N)의 실패율을 HashMap에 저장 (key: 스테이지 번호, value: 실패율)
        Map<Integer, Double> stageFailMap = new HashMap<>();
        int totalPlayers = stages.length; // 현재 스테이지에 도달한 플레이어 수
        
        for (int i = 1; i <= N; i++) {
            double failRate = 0.0;
            if (totalPlayers > 0) {
                failRate = (double) count[i] / totalPlayers;
            }
            stageFailMap.put(i, failRate);
            totalPlayers -= count[i]; // 다음 스테이지로 넘어가는 플레이어 수 계산
        }
        
        // 3. HashMap의 Entry들을 리스트로 변환하여 정렬
        //    정렬 기준: 실패율 내림차순, 실패율이 같다면 스테이지 번호 오름차순
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(stageFailMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
                int cmp = Double.compare(e2.getValue(), e1.getValue()); // 실패율 내림차순
                if (cmp == 0) { // 실패율이 동일하면 스테이지 번호 오름차순
                    return Integer.compare(e1.getKey(), e2.getKey());
                }
                return cmp;
            }
        });
        
        // 4. 정렬된 순서대로 스테이지 번호를 결과 배열에 저장
        int[] answer = new int[N];
        int index = 0;
        for (Map.Entry<Integer, Double> entry : entryList) {
            answer[index++] = entry.getKey();
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<int[]> groups = new ArrayList<>();
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        // 광물을 5개 단위로 끊고, 각 묶음의 피로도 계산
        for (int i = 0; i < minerals.length && groups.size() < totalPicks; i += 5) {
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    dia += 1; iron += 5; stone += 25;
                } else if (m.equals("iron")) {
                    dia += 1; iron += 1; stone += 5;
                } else { // stone
                    dia += 1; iron += 1; stone += 1;
                }
            }
            groups.add(new int[]{dia, iron, stone});
        }

        // 피로도가 많이 드는 묶음부터 정렬 (stone 기준 내림차순)
        groups.sort((a, b) -> b[2] - a[2]);

        int answer = 0;
        int idx = 0;

        // 좋은 곡괭이부터 사용
        for (int i = 0; i < groups.size(); i++) {
            int[] group = groups.get(i);
            if (picks[0] > 0) {
                answer += group[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += group[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += group[2];
                picks[2]--;
            } else break;
        }

        return answer;
    }
}
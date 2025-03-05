import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];

        // 학생별 평균 점수 계산
        Integer[] indices = new Integer[n];
        double[] avg = new double[n];

        for (int i = 0; i < n; i++) {
            avg[i] = (score[i][0] + score[i][1]) / 2.0;
            indices[i] = i; // 원래 순서를 유지하기 위한 인덱스 배열
        }

        // 평균 점수를 기준으로 내림차순 정렬 (높은 점수 먼저)
        Arrays.sort(indices, (a, b) -> Double.compare(avg[b], avg[a]));

        // 등수 매기기
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && avg[indices[i]] != avg[indices[i - 1]]) {
                rank = i + 1; // 이전 점수와 다르면 현재 등수 적용
            }
            answer[indices[i]] = rank;
        }

        return answer;
    }
}

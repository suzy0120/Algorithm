import java.util.*;

class Solution {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        char[][] warehouse = new char[n][m];

        // 문자열 배열을 char 2D 배열로 변환
        for (int i = 0; i < n; i++) {
            warehouse[i] = storage[i].toCharArray();
        }

        for (String req : requests) {
            char letter = req.charAt(0);

            // **크레인 사용 시 (모든 문자를 제거)**
            if (req.length() == 2) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (warehouse[i][j] == letter) {
                            warehouse[i][j] = '.'; // 컨테이너 제거
                        }
                    }
                }
                continue;
            }

            // **지게차 사용 시 (접근 가능한 문자만 제거)**
            boolean[][] outside = new boolean[n][m];
            Queue<int[]> queue = new LinkedList<>();

            // **1. 바깥쪽 '.'(빈 공간) 찾기**
            for (int i = 0; i < n; i++) {
                if (warehouse[i][0] == '.') {
                    queue.add(new int[]{i, 0});
                    outside[i][0] = true;
                }
                if (warehouse[i][m - 1] == '.') {
                    queue.add(new int[]{i, m - 1});
                    outside[i][m - 1] = true;
                }
            }
            for (int j = 0; j < m; j++) {
                if (warehouse[0][j] == '.') {
                    queue.add(new int[]{0, j});
                    outside[0][j] = true;
                }
                if (warehouse[n - 1][j] == '.') {
                    queue.add(new int[]{n - 1, j});
                    outside[n - 1][j] = true;
                }
            }

            // **2. BFS로 외부와 연결된 빈 공간 표시**
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int y = cur[0], x = cur[1];

                for (int[] dir : direction) {
                    int nextY = y + dir[0];
                    int nextX = x + dir[1];

                    if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                        continue;
                    }
                    if (warehouse[nextY][nextX] == '.' && !outside[nextY][nextX]) {
                        outside[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }

            // **3. 접근 가능한 컨테이너 찾기**
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (warehouse[i][j] != letter) continue;

                    boolean accessible = false;

                    // **테두리에 있으면 바로 제거 가능**
                    if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                        accessible = true;
                    } else {
                        // **4방향 중 하나라도 접근 가능하면 제거**
                        for (int[] dir : direction) {
                            int nextY = i + dir[0];
                            int nextX = j + dir[1];

                            if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                                accessible = true;
                                break;
                            }
                            if (warehouse[nextY][nextX] == '.' && outside[nextY][nextX]) {
                                accessible = true;
                                break;
                            }
                        }
                    }

                    // **제거할 컨테이너 표시**
                    if (accessible) {
                        warehouse[i][j] = '.';
                    }
                }
            }
        }

        // **남아 있는 컨테이너 개수 세기**
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (warehouse[i][j] != '.') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
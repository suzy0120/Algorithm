import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동기의 수
        int m = sc.nextInt(); // 친구 관계의 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 주인공(1번)부터 시작
        visited[1] = true;

        int count = 0;
        int level = 0;

        while (!queue.isEmpty() && level < 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int friend : graph.get(current)) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                        count++;
                    }
                }
            }
            level++;
        }

        System.out.println(count);
    }
}
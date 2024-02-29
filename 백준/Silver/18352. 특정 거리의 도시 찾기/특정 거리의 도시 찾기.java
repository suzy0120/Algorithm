import java.util.*;

public class Main {

    static int N, M, K, X;
    static int[] visited;
    static ArrayList<Integer>[] graph;
    static List<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        X = sc.nextInt();
        graph = new ArrayList[N+1];
        answer = new ArrayList<>();
        visited = new int[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }

        for(int i=0; i<=N; i++) {
            visited[i] = -1;
        }

        BFS(X);

        for(int i=0; i<=N; i++) {
            if(visited[i]==K) {
                answer.add(i);
            }
        }

        if(answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);
            for(int temp : answer) System.out.println(temp);
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;
        while(!queue.isEmpty()) {
            int now_node = queue.poll();

            for (int destination : graph[now_node]){
                if (visited[destination]==-1){
                    visited[destination] = visited[now_node] + 1;
                    queue.add(destination);
                }
            }
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=1; i<=N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1; i<=N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		int[] parent = new int[N+1];
		
		BFS(graph, parent, N);
		
		for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
	}
	
	public static void BFS(List<List<Integer>> graph, int[] parent, int N) {
		boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int neighbor : graph.get(current)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current; // 부모 설정
                    queue.offer(neighbor);
                }
            }
        }
	}
}

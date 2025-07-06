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
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int[] parent = new int[N+1];
		BFS(graph, parent, N);
		
		for(int i=2; i<=N; i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void BFS(List<List<Integer>> graph, int[] parent, int N) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
        
		q.offer(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : graph.get(cur)) {
				if(!visited[next]) {
					parent[next] = cur; // 부모 설정
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}

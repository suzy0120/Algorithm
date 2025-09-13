import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
	static List<List<Integer>> adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>(N+1);
        for(int i=0; i<=N; i++) {
        	adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	adj.get(u).add(v);
        	adj.get(v).add(u);
        }
        
        visited = new boolean[N+1];
        int count = 0;
        for(int i=1; i<=N; i++) {
        	if(!visited[i]) {
        		DFS(i);
        		count++;
        	}
        }
        
        System.out.println(count);
	}
    
    public static void DFS(int u) {
    	visited[u] = true;
		for(int v : adj.get(u)) {
			if(!visited[v]) DFS(v);
		}
    }
}

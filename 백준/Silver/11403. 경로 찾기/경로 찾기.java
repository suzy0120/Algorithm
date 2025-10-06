import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int N;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        graph = new int[N][N];
        for(int i=0; i<N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	visited = new boolean[N];
        	DFS(i);
        	
        	for(int j=0; j<N; j++) {
        		sb.append(visited[j] ? "1 " : "0 ");
        	}
        	sb.append("\n");
        }
        
        System.out.print(sb.toString());
	}
    
    public static void DFS(int start) {
    	for(int next=0; next<N; next++) {
    		if(graph[start][next] == 1 && !visited[next]) {
    			visited[next] = true;
    			DFS(next);
    		}
    	}
    } 
}

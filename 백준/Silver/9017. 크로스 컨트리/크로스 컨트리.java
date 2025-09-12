import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=0; tc<T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int[] order = new int[N];
        	int[] teamCount = new int[N+1];
        	for(int i=0; i<N; i++) {
        		order[i] = Integer.parseInt(st.nextToken());
        		teamCount[order[i]]++;
        	}
        	
        	List<Integer>[] pos = new ArrayList[N+1];
        	for(int i=1; i<=N; i++) {
        		if(teamCount[i] >= 6) pos[i] = new ArrayList<>();
        	}
        	
        	int rank = 1;
        	for(int i=0; i<N; i++) {
        		int team = order[i];
        		if(pos[team] != null) {
        			pos[team].add(rank++);
        		}
        	}
        	
            int win = 0;
            int bestSum = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;
        	for(int i=1; i<=N; i++) {
        		if(pos[i] == null)  continue;
        		
        		int sum = pos[i].get(0) + pos[i].get(1) + pos[i].get(2) + pos[i].get(3);
        		int fifth = pos[i].get(4);
        		
        		if(sum < bestSum || (sum == bestSum && fifth < bestFifth)) {
        			bestSum = sum;
        			bestFifth = fifth;
        			win = i;
        		}
        	}
        	
        	System.out.println(win);
        }
	}
}

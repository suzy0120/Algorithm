import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=0; tc<T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int[] order = new int[N];
        	Map<Integer, Integer> teams = new HashMap<>();
        	for(int i=0; i<N; i++) {
        		order[i] = Integer.parseInt(st.nextToken());
        		teams.put(order[i], teams.getOrDefault(order[i], 0)+1);
        	}
        	
        	Map<Integer, List<Integer>> pos = new HashMap<>();
        	for(Map.Entry<Integer, Integer> entry : teams.entrySet()) {
        		if(entry.getValue() < 6) continue;
        		
        		pos.putIfAbsent(entry.getKey(), new ArrayList<>());
        	}
        	
        	int rank = 1;
        	for(int i=0; i<N; i++) {
        		if(pos.containsKey(order[i])) pos.get(order[i]).add(rank++);
        	}
        	
            int win = 0;
            int bestSum = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;
        	for(Map.Entry<Integer, List<Integer>> entry : pos.entrySet()) {
        		int sum = 0;
        		for(int i=0; i<4; i++) {
        			sum += entry.getValue().get(i);
        		}
        		int fifth = entry.getValue().get(4);
        		
        		if(sum < bestSum || (sum == bestSum && fifth < bestFifth)) {
        			bestSum = sum;
        			bestFifth = fifth;
        			win = entry.getKey();
        		}
        	}
        	
        	System.out.println(win);
        }
	}
}

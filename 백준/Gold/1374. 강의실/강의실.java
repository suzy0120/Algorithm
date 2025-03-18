import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] time = new int[N][2];
		for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int num = Integer.parseInt(st.nextToken());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, Comparator.comparing(a -> a[0]));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int[] t : time) {
			if(!pq.isEmpty() && pq.peek()<=t[0]) {
				pq.poll();
			}
			
			pq.offer(t[1]);
		}
		
		System.out.println(pq.size());
	}
}
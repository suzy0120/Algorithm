import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		int answer = 0;
		int[] count = new int[N+1];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			
			map.put(num, map.getOrDefault(num, 0)+1);
			
			if(map.get(num) > 1) {
				if(count[num] != pos) answer++;
			}
			
			count[num] = pos;
		}
		
		System.out.println(answer);
	}
}

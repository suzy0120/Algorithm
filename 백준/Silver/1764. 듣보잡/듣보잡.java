import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<N+M; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		List<String> list = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= 2) {
				list.add(entry.getKey());
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String s : list) {
			System.out.println(s);
		}
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 🔥 출력 최적화
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			
			if(s.length() < M) continue;
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((e1, e2) -> {
			if(!e1.getValue().equals(e2.getValue())) {
				return e2.getValue() - e1.getValue();
			}
			if(e1.getKey().length() != e2.getKey().length()) {
				return e2.getKey().length() - e1.getKey().length();
			}
			return e1.getKey().compareTo(e2.getKey());
		});
		
		for(Map.Entry<String, Integer> entry : list) {
			bw.write(entry.getKey());
			bw.newLine();
		}
        bw.flush();
	}
}

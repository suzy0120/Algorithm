import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>();
		
		for(int tc=0; tc<N; tc++) {
			String file = br.readLine();
			
			int idx = -1;
			for(int i=0; i<file.length(); i++) {
				if(file.charAt(i) == '.') {
					idx = i+1;
					break;
				}
			}
			
			String s = file.substring(idx);
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			
			Map<Character, Integer> map = new HashMap<>();
			
			for(char c : str.toCharArray()) {
				if(c == ' ') continue;
				
				map.put(c, map.getOrDefault(c, 0)+1);
			}
			
			int max = Integer.MIN_VALUE;
			for(int n : map.values()) {
				max = Math.max(max, n);
			}
			
			char result = '?';
			int count = 0;
			for(char c : map.keySet()) {
				if(map.get(c) == max) {
					result = c;
					count++;
				}
			}
			
			System.out.println(count>1 ? '?' : result);
		}
	}
}

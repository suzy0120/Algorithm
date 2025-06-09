import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int tc=0; tc<N; tc++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			String[] word = new String[st.countTokens()];
			String[] copy = new String[st.countTokens()];
			for(int i=0; i<word.length; i++) {
				word[i] = st.nextToken();
				copy[i] = word[i].toLowerCase();
			}
			
			int first = -1, cnt = 0;
			for(int i=0; i<copy.length; i++) {
				if(!map.containsKey(copy[i].charAt(0))) {
					map.put(copy[i].charAt(0), i+1);
					first = i;
					break;
				}
				cnt++;
			}
			
			int second = 0;
			if(cnt == copy.length) {
				loop: for(int i=0; i<copy.length; i++) {
					for(int j=1; j<copy[i].length(); j++) {
						if(!map.containsKey(copy[i].charAt(j))) {
							map.put(copy[i].charAt(j), j);
							first = i;
							second = j;
							break loop;
						}
					}
				}
			}
			
			for(int i=0; i<word.length; i++) {
				if(i == first) {
					if(second > 0) {
						System.out.print(word[i].substring(0, second) + "[" + word[i].charAt(second) + "]" + word[i].substring(second+1) + " ");
						continue;
					}
					
					System.out.print("[" + word[i].charAt(0) + "]" + word[i].substring(1) + " ");
					continue;
				}
				
				System.out.print(word[i] + " ");
			}
			System.out.println();
		}
	}
}

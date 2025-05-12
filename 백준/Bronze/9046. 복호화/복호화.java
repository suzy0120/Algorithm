import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			
			int[] count = new int[26];
			for(char c : str.toCharArray()) {
				if(c == ' ') continue;
				
				count[c-'a']++;
			}
			
			int max = 0, idx = -1;
			boolean dup = false;
			
			for(int i=0; i<26; i++) {
				if(count[i] > max) {
					max = count[i];
					idx = i;
					dup = false;
				} else if(count[i]==max && count[i]!=0) {
					dup = true;
				}
			}
			
			System.out.println(dup ? '?' : (char)(idx+'a'));
		}
	}
}

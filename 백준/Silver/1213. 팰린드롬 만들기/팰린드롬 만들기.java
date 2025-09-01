import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] count = new int[26];
		for(char c : str.toCharArray()) {
			count[c - 'A']++;
		}
		
		int odd = 0;
		int oddIdx = -1;
		for(int i=0; i<26; i++) {
			if(count[i] % 2 == 1) {
				odd++;
				oddIdx = i;
			}
		}
		
		if(odd > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		StringBuilder half = new StringBuilder();
		for(int i=0; i<26; i++) {
			for(int j=0; j<count[i]/2; j++) {
				half.append((char) (i + 'A'));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(half);
		if(odd == 1) sb.append((char) (oddIdx + 'A'));
		sb.append(half.reverse());
		
		System.out.println(sb);
	}
}

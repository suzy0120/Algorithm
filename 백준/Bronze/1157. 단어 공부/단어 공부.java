import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] count = new int[26];
		for(char c : str.toCharArray()) {
			if('a' <= c && c <= 'z') c = (char)(c-'a'+'A');
			count[c-'A']++;
		}
		
		int max = Integer.MIN_VALUE;
		int idx = -1;
		boolean b = false;
		for(int i=0; i<count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				idx = i;
				b = false;
			} else if(count[i] == max) {
				b = true;
			}
		}
		
		System.out.println(b ? "?" : (char)(idx+'A'));
	}
}

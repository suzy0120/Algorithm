import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			
			int[] count = new int[26];
			for(char c : str.toCharArray()) {
				if(c == ' ') continue;
				
				count[c - 'a']++;
			}
			
			int max = 0;
			int idx = -1;
			boolean b = false;
			for(int j=0; j<count.length; j++) {
				if(count[j] > max) {
					max = count[j];
					idx = j;
					b = false;
				} else if(count[j] == max) {
					b = true;
				}
			}
			
			System.out.println(b ? "?" : (char)(idx+'a'));
		}
	}
}

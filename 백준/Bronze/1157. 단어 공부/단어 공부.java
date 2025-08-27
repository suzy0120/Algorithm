import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		str = str.toUpperCase();
		
		int[] count = new int[26];
		for(char c : str.toCharArray()) {
			count[c-65]++;
		}
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for(int i=0; i<count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				idx = i;
			}
		}
		
		int cnt = 0;
		for(int n : count) {
			if(n == max) cnt++;
		}
		
		if(cnt > 1) System.out.println("?");
		else System.out.println((char) (idx+65));
	}
}

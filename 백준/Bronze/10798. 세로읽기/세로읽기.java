import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = new String[5];
		int max = 0;
		for(int i=0; i<5; i++) {
			s[i] = br.readLine();
			if(s[i].length() > max) max = s[i].length();
		}
		
		String answer = "";
		for(int i=0; i<max; i++) {
			for(int j=0; j<5; j++) {
				if(i >= s[j].length()) continue;
				answer += s[j].charAt(i);
			}
		}
		
		System.out.println(answer);
	}
}

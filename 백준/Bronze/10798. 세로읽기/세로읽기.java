import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String[] words = new String[5];
		int max = 0;
		for(int i=0; i<5; i++) {
			words[i] = br.readLine();
			max = Math.max(max, words[i].length());
		}
		
		String result = "";
		for(int c=0; c<max; c++) {
			for(int r=0; r<5; r++) {
				if(c < words[r].length()) result += words[r].charAt(c);
			}
		}
		
		System.out.println(result);
	}
}

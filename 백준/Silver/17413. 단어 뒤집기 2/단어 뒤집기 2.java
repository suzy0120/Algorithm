import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '<') {
				if(word.length() != 0) {
					sb.append(word.reverse());
					word.setLength(0);
				}
				
				sb.append('<');
				for(int j=i+1; j<str.length(); j++) {
					if(str.charAt(j) == '>') {
						i = j;
						break;
					}
					sb.append(str.charAt(j));
				}
				sb.append('>');
				
				continue;
			}
			
			if(str.charAt(i) == ' ') {
				sb.append(word.reverse());
				sb.append(" ");
				word.setLength(0);
				continue;
			}
			
			word.append(str.charAt(i));
		}
		
		if(word.length() != 0) sb.append(word.reverse());
		
		System.out.println(sb.toString());
	}
}

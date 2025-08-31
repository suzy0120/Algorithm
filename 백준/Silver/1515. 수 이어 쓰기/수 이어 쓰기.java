import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int idx = 0;
		int num = 0;
		
		while(idx < str.length()) {
			num++;
			String snum = String.valueOf(num);
			
			for(int i=0; i<snum.length() && idx<str.length(); i++) {
				if(snum.charAt(i) == str.charAt(idx)) {
					idx++;
				}
			}
		}
		
		System.out.println(num);
	}
}

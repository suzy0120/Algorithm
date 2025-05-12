import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String str = br.readLine();
		
		int aCount = 0;
		for(char c : str.toCharArray()) {
			if(c == 'a') aCount++;
        }
		
		String doubleS = str + str;
		
		int bCount = 0;
		for(int i=0; i<aCount; i++) {
			if(doubleS.charAt(i) == 'b') bCount++;
		}
		
		int result = bCount;
		for(int i=1; i<str.length(); i++) {
			if(doubleS.charAt(i-1) == 'b') bCount--;
			if(doubleS.charAt(i+aCount-1) == 'b') bCount++;
			
			result = Math.min(result, bCount);
		}
		
		System.out.println(result);
	}
}

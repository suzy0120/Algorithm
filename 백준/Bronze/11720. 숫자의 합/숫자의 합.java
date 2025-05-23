import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String num = br.readLine();
		
		int sum = 0;
		for(int n : num.toCharArray()) {
			n -= '0';
			sum += n;
		}
		
		System.out.println(sum);
	}
}

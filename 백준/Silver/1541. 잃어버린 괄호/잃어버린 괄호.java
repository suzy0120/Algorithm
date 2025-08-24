import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] st = str.split("-");
		
		List<Integer> list = new ArrayList<>();
		
		for(String s : st) {
			int sum = 0;
			String[] st1 = s.split("\\+");
			for(String s1 : st1) {
				sum += Integer.parseInt(s1);
			}
			
			list.add(sum);
		}
		
		long answer = list.get(0);
		for(int i=1; i<list.size(); i++) {
			answer -= list.get(i);
		}
		
		System.out.println(answer);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) {
				int n = Integer.parseInt(st.nextToken());
				stack.push(n);
			} else if(s.equals("pop")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			} else if(s.equals("size")) {
				System.out.println(stack.size());
			} else if(s.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if(s.equals("top")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			}
		}
	}
}

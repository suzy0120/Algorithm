import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			
			if(s.contains("push")) {
				s = s.substring(5);
				int num = Integer.parseInt(s);
				stack.push(num);
			} else if(s.contains("pop")) {
				if(stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.pop());
			} else if(s.contains("size")) {
                System.out.println(stack.size());
            } else if(s.contains("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if(s.contains("top")) {
				if(stack.isEmpty()) System.out.println(-1);
			    else System.out.println(stack.peek());
			}
		}
	}
}

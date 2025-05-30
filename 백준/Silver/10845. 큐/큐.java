import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<>();
		int last = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				last = num;
			} else if(s.equals("pop")) {
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.poll());
			} else if(s.equals("size")) {
				System.out.println(queue.size());
			} else if(s.equals("empty")) {
				if(queue.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if(s.equals("front")) {
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.peek());
			} else if(s.equals("back")) {
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(last);
			}
		}
	}
}

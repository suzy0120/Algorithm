import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		String[] arr = s.split(" ");
		
		int[] lamps = new int[N+1];
		for(int i=1; i<lamps.length; i++) {
			lamps[i] = Integer.parseInt(arr[i-1]);
		}
		
		for(int tc=0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				lamps[b] = c;
			} else if(a == 2) {
				for(int i=b; i<=c; i++) {
					if(lamps[i] == 0) lamps[i] = 1;
					else lamps[i] = 0;
				}
			} else if(a == 3) {
				for(int i=b; i<=c; i++) {
					lamps[i] = 0;
				}
			} else {
				for(int i=b; i<=c; i++) {
					lamps[i] = 1;
				}
			}
		}
		
		for(int i=1; i<lamps.length; i++) {
			System.out.print(lamps[i]);
			
			if(i == N) continue;
			System.out.print(" ");
		}
	}
}

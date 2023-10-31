import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] arr2 = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		// 카운팅 정렬
		int[] count = new int[20000002];
		for(int i = 0; i < arr1.length; i++) {
			count[arr1[i]+10000000]++;
		}
		
		for(int i = 0; i < arr2.length; i++) {
			sb.append(count[arr2[i]+10000000]).append(" ");
		}
		
		bw.write(sb + "");
		bw.close();
	}
}
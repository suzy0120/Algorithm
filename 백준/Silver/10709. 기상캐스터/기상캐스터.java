import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        char[][] cloud = new char[H][W];
        for (int r = 0; r < H; r++) {
            String s = br.readLine();
            cloud[r] = s.toCharArray();
        }
        
		int[][] answer = new int[H][W];
		for(int r=0; r<H; r++) {
			boolean found = false;
			int count = 0;
			
			for(int c=0; c<W; c++) {
				if(cloud[r][c] == 'c') {
					answer[r][c] = 0;
					found = true;
					count = 0;
				}
				else {
					if(found) {
						count++;
						answer[r][c] = count;
					} else {
						answer[r][c] = -1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				sb.append(answer[r][c]);
				if(c != W-1) sb.append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] price = new int[14];
        for(int i=0; i<14; i++) {
        	price[i] = Integer.parseInt(st.nextToken());
        }
        
        int remainJ = N;
        int haveJ = 0;
        for(int i=0; i<14; i++) {
			if(remainJ >= price[i]) {
				haveJ += remainJ / price[i];
				remainJ %= price[i]; 
			}
		}
        int totalJ = remainJ + haveJ * price[13];
        
        int remainS = N;
        int haveS = 0;
        int up = 0, down = 0;
        for(int i=1; i<14; i++) {
        	if(price[i] > price[i-1]) {
        		up++;
        		down = 0;
        	} else if(price[i] < price[i-1]) {
        		down++;
        		up = 0;
        	} else {
        		up = down = 0;
        	}
        	
        	if(up >= 3) {
        		remainS += haveS * price[i];
        		haveS = 0;
        	} else if(down >= 3) {
        		haveS += remainS / price[i];
        		remainS %= price[i];
        	}
		}
		int totalS = remainS + haveS * price[13];
        
		if(totalJ > totalS) System.out.println("BNP");
        else if(totalJ < totalS) System.out.println("TIMING");
        else System.out.println("SAMESAME");
	}
}

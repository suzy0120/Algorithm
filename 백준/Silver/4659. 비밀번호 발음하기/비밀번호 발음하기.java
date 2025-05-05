import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        
        while(true) {
    		String word = br.readLine();
        	if(word.equals("end")) break;
            
            boolean pw = true;
            boolean hasVowel = false;
            int vcnt=0, ccnt=0;
            
    		for(int i=0; i<word.length(); i++) {
    			char c = word.charAt(i);
    			
    			if(vowel.contains(c)) {
    				hasVowel = true;
    				vcnt++;
    				ccnt = 0;
    			} else {
    				ccnt++;
    				vcnt = 0;
    			}
    			
    			if(vcnt>=3 || ccnt>=3) {
    				pw = false;
    				break;
    			}
    			
    			if(i<word.length()-1 && c==word.charAt(i+1) && c!='e' && c!='o') {
    				pw = false;
    				break;
    			}
    		}
    		
    		if(!hasVowel) pw = false;
    		
    		if(pw) System.out.println("<" + word + "> is acceptable.");
    		else System.out.println("<" + word + "> is not acceptable.");
        }
	}
}

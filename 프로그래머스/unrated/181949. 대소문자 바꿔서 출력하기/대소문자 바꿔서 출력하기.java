import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] c = a.toCharArray();
        for(int i = 0; i < c.length; i++) {
        	if(65 <= c[i] && c[i] <= 90) {
            	c[i] = (char) (c[i] + 32);
            } else {
            	c[i] = (char) (c[i] - 32);
            }
        }
        
        for(int i = 0; i < c.length; i++) {
        	System.out.print(c[i]);
        }
    }
}
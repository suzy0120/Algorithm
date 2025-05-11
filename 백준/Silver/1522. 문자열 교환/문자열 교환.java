import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        
        int aCount = 0;
        for(int i=0; i<len; i++) {
            if(s.charAt(i) == 'a') aCount++;
        }
        
        String doubleS = s + s;
        
        int bCount = 0;
        for(int i=0; i<aCount; i++) {
            if(doubleS.charAt(i) == 'b') bCount++;
        }
        
        int min = bCount;
        
        for(int i=1; i<len; i++) {
            if(doubleS.charAt(i-1) == 'b') bCount--;
            if(doubleS.charAt(i+aCount-1) == 'b') bCount++;
            min = Math.min(min, bCount);
        }
        
        System.out.println(min);
    }
}

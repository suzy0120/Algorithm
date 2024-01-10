import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if(x != 1) {
			while(x > 1) {
				 y += month[x-2];
				 x--;
			}
		}
		
		if(y%7 == 0) System.out.println("SUN");
		else if(y%7 == 1) System.out.println("MON");
		else if(y%7 == 2) System.out.println("TUE");
		else if(y%7 == 3) System.out.println("WED");
		else if(y%7 == 4) System.out.println("THU");
		else if(y%7 == 5) System.out.println("FRI");
		else if(y%7 == 6) System.out.println("SAT");
	}
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int number = 666;
        int cnt = 1;

        while(cnt != N) {
            number++;
            if(String.valueOf(number).contains("666")) cnt++;
        }

        System.out.println(number);
    }
}
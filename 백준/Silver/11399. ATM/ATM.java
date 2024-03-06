import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        for(int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int[] sum = new int[N];
        sum[0] = P[0];
        int min = P[0];
        for(int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + P[i];
            min += sum[i];
        }

        System.out.println(min);
    }
}
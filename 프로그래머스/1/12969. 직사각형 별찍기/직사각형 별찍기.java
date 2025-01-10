import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int r=1; r<=m; r++) {
            for(int c=1; c<=n; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
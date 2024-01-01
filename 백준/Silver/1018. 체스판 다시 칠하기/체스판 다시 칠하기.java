import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[][] board = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            String s = sc.next();
            for(int c = 0; c < M; c++) {
                board[r][c] = s.charAt(c) == 'W'; // W일 때는 true, B일 때는 false
            }
        }

        int min = Integer.MAX_VALUE;
        for(int r = 0; r < N-7; r++) {
            for(int c = 0; c < M-7; c++) {
                int count1 = 0; // 첫 칸이 W일 경우
                int count2 = 0; // 첫 칸이 B일 경우
                
                for(int a = r; a < r+8; a++) {
                    for(int b = c; b < c+8; b++) {
                        // (a + b)의 합이 짝수인 경우 원래 색과 일치하는지 확인
                        if ((a + b) % 2 == 0) {
                            if (board[a][b]) count2++;
                            else count1++;
                        } else {
                            if (!board[a][b]) count2++;
                            else count1++;
                        }
                    }
                }
                
                min = Math.min(min, Math.min(count1, count2));
            }
        }
        
        System.out.println(min);
    }
}
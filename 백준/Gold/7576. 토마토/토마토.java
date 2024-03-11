import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] dr = {0, 0, 1, -1}; // 왼쪽, 오른쪽, 앞, 뒤
	public static int[] dc = {-1, 1, 0, 0};
	public static int M, N;
	public static int[][] tomato;
	public static boolean[][] visit;
	public static int day = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 가로
		N = sc.nextInt(); // 세로
		tomato = new int[N][M];
		visit = new boolean[N][M];
		boolean check = true;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tomato[i][j] = sc.nextInt();
				if(tomato[i][j] == 0) check = false;
			}
		}
		
		// 저장될 때부터 모든 토마토가 익어있는 경우 0 출력
        if(check) {
            System.out.println(0);
        } else {
            BFS();
    		
            // 모든 토마토가 익는 데 걸리는 시간을 출력
            if(isAllRipe()) {
                System.out.println(day);
            } else {
                System.out.println(-1);
            }
        }
	}

	public static void BFS() {
		Queue<Integer[]> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 1) {
                    queue.add(new Integer[] {i, j});
                    visit[i][j] = true;
                }
            }
        }
		
		while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
				Integer[] rc = queue.poll();
				int r = rc[0];
				int c = rc[1];
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(0 <= nr && nr < N && 0 <= nc && nc < M && tomato[nr][nc] == 0 && !visit[nr][nc]) {
						tomato[nr][nc] = 1;
						visit[nr][nc] = true;
						queue.add(new Integer[] {nr, nc});
					}
				}
            }
            // 하루가 지나면 day 증가
            day++;
		}
	}
	
    // 모든 토마토가 익었는지 확인하는 메소드
    public static boolean isAllRipe() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 0) return false; // 토마토가 모두 익지 못하는 상황이면
            }
        }
        return true;
    }
}
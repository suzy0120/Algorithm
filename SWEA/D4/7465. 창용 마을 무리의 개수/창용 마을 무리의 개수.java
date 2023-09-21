import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수

			int[][] edges = new int[E][2];

			for (int i = 0; i < E; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
			}

			p = new int[V+1];
			for (int i = 0; i < V+1; i++) {
				p[i] = i;
			}

			for (int i = 0; i < E; i++) {
				int px = findset(edges[i][0]);
				int py = findset(edges[i][1]);
				
				if (px != py) {
					// 여기에 들어왔다라는 뜻은 사이클이 형성이 안된다라는 뜻
					union(px, py);
				}
			}
			
			List<Integer> list = new ArrayList<>();
			for(int i = 1; i < p.length; i++) {
				int root = findset(p[i]);
				if(list.contains(root))
					continue;
				list.add(root);
			}
			
			System.out.println("#" + tc + " " + list.size());
		}
	}

	static void union(int x, int y) {
		if(x < y) {
			p[y] = x;
		} else {
			p[x] = y;
		}
	}

	static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}

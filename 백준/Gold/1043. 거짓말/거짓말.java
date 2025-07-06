import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static List<Integer>[] graph;
	public static boolean[] knowsTruth;
	public static List<List<Integer>> parties = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		
		graph = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int truth = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		knowsTruth = new boolean[N+1];
		for(int i=0; i<truth; i++) {
			int person = Integer.parseInt(st.nextToken());
			knowsTruth[person] = true;
			queue.add(person);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int partyPeople = Integer.parseInt(st.nextToken()); // 파티에 오는 사람 수
			
			int[] people = new int[partyPeople];
			List<Integer> party = new ArrayList<>();
			for(int j=0; j<partyPeople; j++) {
				people[j] = Integer.parseInt(st.nextToken());
				party.add(people[j]);
			}
			
			for(int a=0; a<people.length; a++) {
				for(int b=a+1; b<people.length; b++) {
					graph[people[a]].add(people[b]);
					graph[people[b]].add(people[a]);
				}
			}
			
			parties.add(party);
		}
		
		BFS();
		
		int count = 0;
		for(List<Integer> list : parties) {
			boolean lie = true;
			
			for(int n : list) {
				if(knowsTruth[n]) {
					lie = false;
					break;
				}
			}
			
			if(lie) count++;
		}
		
		System.out.println(count);
	}
	
	public static void BFS() {
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int neighbor : graph[cur]) {
				if(!knowsTruth[neighbor]) {
					knowsTruth[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}
}

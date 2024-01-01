import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visit = new boolean[n + 1];

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
        	int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        int count = 0;
        visit[1] = true;
        
        List<Integer> sangGeun = list.get(1);
        for(int a : sangGeun) {
            if(!visit[a]) count++;
            visit[a] = true;
            
            List<Integer> friend = list.get(a);
            for(int b : friend) {
                if(!visit[b]) count++;
                	visit[b] = true;
            }
        }

        System.out.println(count);
    }
}
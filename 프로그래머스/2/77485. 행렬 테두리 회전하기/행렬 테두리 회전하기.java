import java.util.*;

class Solution {
    public static int[] dr = {0, 1, 0, -1};
    public static int[] dc = {1, 0, -1, 0};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int count = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = count++;
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[queries.length];
        int idx = 0;
        
        for(int i=0; i<queries.length; i++) {
            pq.clear();
            
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            
            int cr = x1;
            int cc = y1;
            int before = matrix[cr][cc];
            
            for(int d=0; d<4; d++) {
                while(true) {
                    cr += dr[d];
                    cc += dc[d];
                    
                    int tmp = matrix[cr][cc];
                    pq.add(tmp);
                    matrix[cr][cc] = before;
                    before = tmp;
                    
                    if(d==0 && cc==y2) break;
                    if(d==1 && cr==x2) break;
                    if(d==2 && cc==y1) break;
                    if(d==3 && cr==x1) break;
                }
            }
            
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}
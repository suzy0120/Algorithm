import java.util.*;

class Solution {
    public static int col;
    
    public int solution(String[][] relation) {
        col = relation[0].length;
        List<Set<Integer>> candidateKeys = new ArrayList<>();
        
        for(int c=1; c<=col; c++) {
            DFS(0, c, new ArrayList<>(), candidateKeys, relation);
        }
        
        int answer = candidateKeys.size();
        return answer;
    }
    
    private void DFS(int start, int c, List<Integer> comb, List<Set<Integer>> candidateKeys, String[][] relation) {
        if(comb.size() == c) {
            // 최소성 검사
            for(Set<Integer> key : candidateKeys) {
                if(comb.containsAll(key)) return;
            }
            
            // 유일성 검사
            Set<String> set = new HashSet<>();
            for(int i=0; i<relation.length; i++) {
                StringBuilder sb = new StringBuilder();
                
                for(int idx : comb) {
                    sb.append(relation[i][idx]).append(",");
                }
                
                set.add(sb.toString());
            }
            
            if(set.size() == relation.length) {
                candidateKeys.add(new HashSet<>(comb));
            }
            
            return;
        }
        
        for(int i=start; i<col; i++) {
            comb.add(i);
            DFS(i+1, c, comb, candidateKeys, relation);
            comb.remove(comb.size() - 1);
        }
    }
}
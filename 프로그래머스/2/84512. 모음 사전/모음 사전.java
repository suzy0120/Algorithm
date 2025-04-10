import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    String[] vowel = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        DFS("", 0);
        
        int answer = list.indexOf(word)+1;
        return answer;
    }
    
    public void DFS(String current, int depth) {
        if(depth > 5) return;
        
        if(!current.isEmpty()) list.add(current);
        
        for(int i=0; i<vowel.length; i++) {
            DFS(current+vowel[i], depth+1);
        }
    }
}
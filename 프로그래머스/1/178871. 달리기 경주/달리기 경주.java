import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++) map.put(players[i], i);
        
        for(String calling : callings) {
            int currentIndex = map.get(calling);
            int frontIndex = currentIndex-1;
            String frontPlayer = players[frontIndex];
            players[frontIndex] = calling;
            players[currentIndex] = frontPlayer;
            
            map.put(calling, frontIndex);
            map.put(frontPlayer, currentIndex);
        }
        
        return players;
    }
}
import java.util.*;

class Solution {
    public int solution(String word) {
        Map<Character, Integer> first = Map.of('A', 1, 'E', 782, 'I', 1563, 'O', 2344, 'U', 3125);
        Map<Character, Integer> second = Map.of('A', 1, 'E', 157, 'I', 313, 'O', 469, 'U', 625);
        Map<Character, Integer> third = Map.of('A', 1, 'E', 32, 'I', 63, 'O', 94, 'U', 125);
        Map<Character, Integer> fourth = Map.of('A', 1, 'E', 7, 'I', 13, 'O', 19, 'U', 25);
        Map<Character, Integer> last = Map.of('A', 1, 'E', 2, 'I', 3, 'O', 4, 'U', 5);
        
        // 맵들을 배열에 담음
        Map<Character, Integer>[] map = new Map[]{first, second, third, fourth, last};
        
        int answer = 0;
        for(int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            answer += map[i].get(letter);
        }
        
        return answer;
    }
}
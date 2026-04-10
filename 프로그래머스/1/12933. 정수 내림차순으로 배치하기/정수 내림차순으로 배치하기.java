import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        
        char[] arr = new char[s.length()];
        int[] num = new int[s.length()];
        int idx = 0;
        
        for(char c : s.toCharArray()) {
            arr[idx] = c;
            num[idx] = c - '0';
            idx++;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int number : num) {
            list.add(number);
        }
        Collections.sort(list, Collections.reverseOrder());
        
        String ans = "";
        for(int i=0; i<list.size(); i++) {
            ans += list.get(i);
        }
        
        answer = Long.parseLong(ans);
        return answer;
    }
}
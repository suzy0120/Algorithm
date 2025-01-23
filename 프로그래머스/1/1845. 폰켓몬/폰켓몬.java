import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int num : nums) hs.add(num);
        
        int maxPick = nums.length/2;
        int uniqueCount = hs.size();
        
        return Math.min(maxPick, uniqueCount);
    }
}
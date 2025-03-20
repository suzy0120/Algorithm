import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int lenA = arrayA.length;
        int lenB = arrayB.length;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int num = 2;
        List<Integer> listA = new ArrayList<>();
        while(num <= arrayA[lenA-1]) {
            for(int i=0; i<lenA; i++) {
                if(arrayA[i]%num != 0) break;
                if(i == lenA-1) listA.add(num);
            }
            
            num++;
        }
        
        num = 2;
        List<Integer> listB = new ArrayList<>();
        while(num <= arrayB[lenB-1]) {
            for(int i=0; i<lenB; i++) {
                if(arrayB[i]%num != 0) break;
                if(i == lenB-1) listB.add(num);
            }
            
            num++;
        }
        
        Collections.sort(listA, Collections.reverseOrder());
        Collections.sort(listB, Collections.reverseOrder());
        
        if(listB.size() != 0) {
            for(int i=0; i<lenA; i++) {
                if(arrayA[i]%listB.get(0) == 0) break;
                if(i == lenA-1) answer = listB.get(0);
            }
        }
        
        if(listA.size() != 0) {
            for(int i=0; i<lenB; i++) {
                if(arrayB[i]%listA.get(0) == 0) break;
                if(i == lenB-1) answer = Math.max(answer, listA.get(0));
            }
        }
        
        return answer;
    }
}
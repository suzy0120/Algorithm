import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] arr = new int[4];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        arr[3] = d;
        Arrays.sort(arr);
        int[] count = new int[7];
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int p = 0;
        int q = 0;
        int[] pArr = new int[2];
        int[] qArr = new int[4];
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] == 1) { 
                qArr[idx1++] = i;
            }
            if(count[i] == 2) { 
                pArr[idx2++] = i;
            }
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 3) { // 1번째
                p = i;
                answer = p * 1111;
            } else if(count[i] == 3) { // 2번째
                p = i;
                answer = (int)Math.pow((10 * p + qArr[0]), 2);
            } else if(count[i] == 2) { // 3, 4번째
                if(pArr[1] != 0) {
                    answer = (pArr[0] + pArr[1]) * Math.abs(pArr[0] - pArr[1]);
                } else {
                    answer = qArr[0] * qArr[1];
                }
            }
            
            if(qArr[3] != 0) { // 5번째
                int min = Math.min(a, b);
                min = Math.min(min, c);
                min = Math.min(min, d);
                answer = min;
            }
        }
        return answer;
    }
}
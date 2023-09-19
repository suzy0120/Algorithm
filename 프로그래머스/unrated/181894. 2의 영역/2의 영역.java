class Solution {
    public int[] solution(int[] arr) {
        int start = 0;
        int end = 0;
        int count = 0;
        loop: for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                count++;
                start = i;
                for(int j = arr.length-1; j >= start; j--) {
                    if(arr[j] == 2) {
                        end = j;
                        break loop;
                    }
                }
            }
        }
        int[] answer;
        if(count == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[end-start+1];
            int idx = 0;
            for(int i = start; i <= end; i++) {
                answer[idx++] = arr[i];
            }  
        }
        return answer;
    }
}
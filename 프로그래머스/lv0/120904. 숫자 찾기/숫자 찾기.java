class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String s = Integer.toString(num);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
	        arr[i] = s.charAt(i) - '0';
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == k) {
                answer = i+1;
                break;
            } else {
                answer = -1;
            }
        }
        return answer;
    }
}
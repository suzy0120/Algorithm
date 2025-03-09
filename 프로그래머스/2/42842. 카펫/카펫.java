class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        
        for(int height=3; height<=sum/height; height++) {
            if(sum%height == 0) {
                int width = sum / height;
                int border = width*2 + height*2 - 4;
                
                if(border == brown) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }
        
        return answer;
    }
}
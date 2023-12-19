class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int c = board[0] / 2;
        int r = board[1] / 2;
        
        for(int i = 0; i < keyinput.length; i++) {
            int x = answer[0];
            int y = answer[1];
            
            if(keyinput[i].equals("up")) {
                y += 1;
            } else if(keyinput[i].equals("down")) {
                y -= 1;
            } else if(keyinput[i].equals("left")) {
                x -= 1;
            } else {
                x += 1;
            }
            
            if(-c <= x && x <= c && -r <= y && y <= r) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        
        return answer;
    }
}
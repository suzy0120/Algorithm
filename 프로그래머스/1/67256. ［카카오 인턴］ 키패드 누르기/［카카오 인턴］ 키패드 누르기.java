class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = {
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}  // 9
        };
        int[] leftPos = {3, 0}; // *
        int[] rightPos = {3, 2}; // #
        
        for(int num : numbers) {
            String pushHand = "";
            
            if(num == 1 || num == 4 || num == 7) pushHand = "L";
            else if(num == 3 || num == 6 || num == 9) pushHand = "R";
            else {
                int[] target = keypad[num];
                int leftDis = Math.abs(leftPos[0] - target[0]) + Math.abs(leftPos[1] - target[1]);
                int rightDis = Math.abs(rightPos[0] - target[0]) + Math.abs(rightPos[1] - target[1]);
                
                if(leftDis < rightDis) pushHand = "L";
                else if(leftDis > rightDis) pushHand = "R";
                else pushHand = hand.equals("right") ? "R" : "L";
            }
            
            answer += pushHand;
            if(pushHand.equals("L")) leftPos = keypad[num];
            else rightPos = keypad[num];
        }
        
        return answer;
    }
}
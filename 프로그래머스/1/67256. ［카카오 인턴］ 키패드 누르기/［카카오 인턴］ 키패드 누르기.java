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
        int[] leftPos = {3, 0};  // '*'
        int[] rightPos = {3, 2}; // '#'
        
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                answer += "L";
                leftPos = keypad[num];
            } else if(num == 3 || num == 6 || num == 9) {
                answer += "R";
                rightPos = keypad[num];
            } else {
                int leftDist = Math.abs(leftPos[0] - keypad[num][0]) 
                             + Math.abs(leftPos[1] - keypad[num][1]);
                int rightDist = Math.abs(rightPos[0] - keypad[num][0]) 
                              + Math.abs(rightPos[1] - keypad[num][1]);
                if(leftDist < rightDist) {
                    answer += "L";
                    leftPos = keypad[num];
                } else if(leftDist > rightDist) {
                    answer += "R";
                    rightPos = keypad[num];
                } else {
                    if(hand.equals("right")) {
                        answer += "R";
                        rightPos = keypad[num];
                    } else {
                        answer += "L";
                        leftPos = keypad[num];
                    }
                }
            }
        }
        
        return answer;
    }
}
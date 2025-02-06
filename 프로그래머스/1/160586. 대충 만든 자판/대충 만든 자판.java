class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        char[][] array = new char[keymap.length][];
        for(int i=0; i<keymap.length; i++) {
            array[i] = keymap[i].toCharArray();
        }
        
        int idx = 0;
        for(String target : targets) {
            int count = 0;
            boolean possible = true;
            for(char t : target.toCharArray()) {
                int min = Integer.MAX_VALUE;
                for(int r=0; r<array.length; r++) {
                    for(int c=0; c<array[r].length; c++) {
                        if(t==array[r][c]) {
                            min = Math.min(min, c+1);
                            break;
                        }
                    }
                }
                if(min==Integer.MAX_VALUE) {
                    possible = false;
                    break;
                }
                else count+=min;
            }
            answer[idx] = possible ? count : -1;
            idx++;
        }
        
        return answer;
    }
}
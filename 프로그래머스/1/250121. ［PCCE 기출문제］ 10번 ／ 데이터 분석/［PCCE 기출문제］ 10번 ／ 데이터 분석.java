import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int filterColumn;
        switch(ext) {
            case "code":
                filterColumn = 0;
                break;
            case "date":
                filterColumn = 1;
                break;
            case "maximum":
                filterColumn = 2;
                break;
            default:
                filterColumn = 3;
                break;
        }
        
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<data.length; i++) {
            if(data[i][filterColumn] < val_ext) {
                list.add(data[i]);
            }
        }
        
        int sortColumn;
        switch(sort_by) {
            case "code":
                sortColumn = 0;
                break;
            case "date":
                sortColumn = 1;
                break;
            case "maximum":
                sortColumn = 2;
                break;
            default:
                sortColumn = 3;
                break;
        }
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                return Integer.compare(row1[sortColumn], row2[sortColumn]);
            }
        });
        
        int[][] answer = new int[list.size()][];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
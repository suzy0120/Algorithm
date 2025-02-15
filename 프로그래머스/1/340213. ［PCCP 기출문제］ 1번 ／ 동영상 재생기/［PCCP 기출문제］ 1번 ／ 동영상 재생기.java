import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalVideo = toMinutes(video_len);
        int current = toMinutes(pos);
        int opStart = toMinutes(op_start);
        int opEnd = toMinutes(op_end);
        
        for(String cmd : commands) {
            if(current >= opStart && current <= opEnd) current = opEnd;
            
            if(cmd.equals("next")) {
                current = Math.min(current + 10, totalVideo);
                if(current >= opStart && current <= opEnd) current = opEnd;
            } else if(cmd.equals("prev")) {
                current = Math.max(current - 10, 0);
                if(current >= opStart && current <= opEnd) current = opEnd;
            }
        }
        
        int hh = current / 60;
        int mm = current % 60;
        return String.format("%02d:%02d", hh, mm);
    }
    
    // "HH:MM" 문자열을 분 단위 정수로 변환하는 메서드
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }
}
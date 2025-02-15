class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalVideo = toMinutes(video_len); // 동영상의 길이
        int current = toMinutes(pos); // 재생위치
        int start = toMinutes(op_start); // 오프닝 시작 시각
        int end = toMinutes(op_end); // 오프닝이 끝나는 시각
        
        for(String cmd : commands) {
            if(current >= start && current <= end) current = end;
            
            if(cmd.equals("next")) {
                current = Math.min(current+10, totalVideo);
                
                if(current >= start && current <= end) current = end;
            } else if(cmd.equals("prev")) {
                current = Math.max(current-10, 0);
                
                if(current >= start && current <= end) current = end;
            }
        }
        
        int hour = current/60;
        int minute = current%60;
        
        String answer = String.format("%02d:%02d", hour, minute);
        
        return answer;
    }
    
    public int toMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh*60 + mm;
    }
}
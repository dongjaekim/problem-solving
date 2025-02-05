package problems.lv1;

public class VideoPlayer {

    public static void main(String[] args) {
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = new String[] { "next", "prev" };
        String e1 = solution(video_len, pos, op_start, op_end, commands);
        System.out.println("e1 = " + e1);
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = pos;
        if (isOpening(answer, op_start, op_end)) {
            answer = op_end;
        }

        for (String command : commands) {
            if ("prev".equals(command)) {
                answer = prev(answer, op_start, op_end);
            } else {
                answer = next(video_len, answer, op_start, op_end);
            }
        }

        return answer;
    }

    public static String prev(String pos, String op_start, String op_end) {
        String[] _split = pos.split(":");
        int timeToSec = Integer.parseInt(_split[0]) * 60 + Integer.parseInt(_split[1]);

        if (timeToSec < 10) {
            timeToSec = 0;
        } else {
            timeToSec -= 10;
        }

        int min = timeToSec / 60;
        int sec = timeToSec % 60;

        pos = String.format("%02d:%02d", min, sec);
        if (isOpening(pos, op_start, op_end)) {
            pos = op_end;
        }

        return pos;
    }

    public static String next(String video_len, String pos, String op_start, String op_end) {
        String[] _videoSplit = video_len.split(":");
        int videoTimeToSec = Integer.parseInt(_videoSplit[0]) * 60 + Integer.parseInt(_videoSplit[1]);

        String[] _split = pos.split(":");
        int timeToSec = Integer.parseInt(_split[0]) * 60 + Integer.parseInt(_split[1]);

        if (videoTimeToSec - timeToSec < 10) {
            timeToSec = videoTimeToSec;
        } else {
            timeToSec += 10;
        }

        int min = timeToSec / 60;
        int sec = timeToSec % 60;

        pos = String.format("%02d:%02d", min, sec);
        if (isOpening(pos, op_start, op_end)) {
            pos = op_end;
        }

        return pos;
    }

    public static boolean isOpening(String pos, String op_start, String op_end) {
        return pos.compareTo(op_start) >= 0 && pos.compareTo(op_end) <= 0;
    }
}

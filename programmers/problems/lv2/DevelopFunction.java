import java.util.*;

class DevelopFunction {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int progress : progresses)
            queue.offer(progress);
        
        int day = 1;
        int idx = 0;
        int cnt = 0;
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (queue.peek() + day * speeds[idx] >= 100) {
                queue.poll();
                idx++;
                cnt++;
            } else {
                if (cnt != 0) {
                    answer.add(cnt);
                    cnt = 0;
                }
                day++;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

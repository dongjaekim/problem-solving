package problems.lv2;

import java.util.*;

public class Process {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Item> queue = new LinkedList<>();

        int idx = 0;
        for (int priority : priorities) {
            queue.offer(new Item(priority, idx++ == location));
        }

        Arrays.sort(priorities);
        int maxIdx = priorities.length - 1;
        int max = priorities[maxIdx];

        while (!queue.isEmpty()) {
            Item item = queue.poll();

            if (item.getPriority() == max) {
                answer++;
                if (item.getIsTarget()) {
                    return answer;
                }
                max = priorities[--maxIdx];
            } else {
                queue.offer(item);
            }
        }

        return answer;
    }

    class Item {
        private int priority;
        private boolean isTarget;

        public Item(int priority, boolean isTarget) {
            this.priority = priority;
            this.isTarget = isTarget;
        }

        public int getPriority() {
            return this.priority;
        }

        public boolean getIsTarget() {
            return this.isTarget;
        }
    }
}

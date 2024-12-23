package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P77OverlappingInterval {

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(5, 8));
        list.add(new Interval(4, 10));
        list.add(new Interval(20, 25));
        list.add(new Interval(15, 26));
        list.add(new Interval(1, 5));
        list.add(new Interval(12, 14));

        List<Interval> intervals = mergeInterval(list);
        System.out.println("intervals = " + intervals);
    }

    public static List<Interval> mergeInterval(List<Interval> intervalList) {
        Collections.sort(intervalList);
        List<Interval> mergedIntervalList = new ArrayList<>();
        System.out.println("intervalList = " + intervalList);

        int index = 0;
        while (index < intervalList.size() - 1) {
            Interval interval = intervalList.get(index);
            for (int i = index + 1; i < intervalList.size(); i++) {
                Interval compare = intervalList.get(i);
                index++;
                if (compare.getTo() > interval.getTo()) {
                    break;
                }
            }
            mergedIntervalList.add(interval);
        }

        return mergedIntervalList;
    }

    static class Interval implements Comparable<Interval> {

        private int from;
        private int to;

        public Interval(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        @Override
        public int compareTo(Interval o) {
            return this.from - o.getFrom() == 0 ? o.getTo() - this.to : this.from - o.getFrom();
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }

    }
}

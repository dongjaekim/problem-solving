package problems.medium;

import java.util.TreeMap;

public class P731MyCalendar2 {
    static class MyCalendarTwo {
        private TreeMap<Integer , Integer> schedule;
        
        public MyCalendarTwo() {
            schedule = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            schedule.put(start, schedule.getOrDefault(start, 0) + 1);
            schedule.put(end, schedule.getOrDefault(end, 0) - 1);
            
            int count = 0;
            System.out.println("map before loop = " + schedule);
            for(int i : schedule.values()){
                count += i;
                if(count > 2) {
                    schedule.put(start, schedule.get(start) - 1);
                    if(schedule.get(start) == 0)
                        schedule.remove(start);

                    schedule.put(end , schedule.get(end) + 1);
                    if(schedule.get(end) == 0)
                        schedule.remove(end);
                    
                  return false;
                }
            }
            System.out.println("map after loop = " + schedule);
            return true;
        }
    }
  
    public static void main(String[] args) {

        MyCalendarTwo obj = new MyCalendarTwo();
        boolean b1 = obj.book(10, 20); // t
        boolean b2 = obj.book(50, 60); // t
        boolean b3 = obj.book(10, 40); // t
        boolean b4 = obj.book(5, 15); // f
        boolean b5 = obj.book(5, 10); // t
        boolean b6 = obj.book(25, 55); // t

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println("b4 = " + b4);
        System.out.println("b5 = " + b5);
        System.out.println("b6 = " + b6);
    }
}

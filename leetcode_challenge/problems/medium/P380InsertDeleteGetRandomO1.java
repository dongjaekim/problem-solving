package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P380InsertDeleteGetRandomO1 {
    static class RandomizedSet {
        List<Integer> list;

        public RandomizedSet() {
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            System.out.println("list = " + list);
            if (list.contains(val)) {
                return false;
            } else {
                list.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            System.out.println("list = " + list);
            if (list.contains(val)) {
                list.remove(Integer.valueOf(val));
                return true;
            } else
                return false;

        }

        public int getRandom() {
            System.out.println("list = " + list);
            Random random = new Random();
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("========= Example 1 =========");
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
    }
}

package problems.hard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class P432AllO1DataStructure {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("b");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.dec("a");
        allOne.dec("a");
        System.out.println("allOne.getMaxKey() = " + allOne.getMaxKey()); //b
        System.out.println("allOne.getMinKey() = " + allOne.getMinKey()); //a
    }

    static class AllOne {

        HashMap<String, Integer> keyCount;
        TreeSet<Pair<Integer, String>> keySet;

        public AllOne() {
            keyCount = new HashMap<>();
            keySet = new TreeSet<>((p1, p2) -> p1.key == p2.key ? p1.value.compareTo(p2.value) : p1.key - p2.key);
        }

        public void inc(String key) {
            Integer count = keyCount.getOrDefault(key, 0) + 1;
            keyCount.put(key, count);
            keySet.add(new Pair<>(count, key));
            if (count != 1)
                keySet.remove(new Pair<>(count - 1, key));
        }

        public void dec(String key) {
            Integer count = keyCount.get(key) - 1;

            if (count == 0) {
                keyCount.remove(key);
            } else {
                keyCount.put(key, count);
            }
            keySet.remove(new Pair<>(count + 1, key));
            if (count != 0) {
                keySet.add(new Pair<>(count, key));
            }
        }

        public String getMaxKey() {
            return keyCount.isEmpty() ? "" : keySet.last().getValue();
        }

        public String getMinKey() {
            return keyCount.isEmpty() ? "" : keySet.first().getValue();
        }
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

}

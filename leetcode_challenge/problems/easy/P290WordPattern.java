package problems.easy;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class P290WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] splits = s.split(" ");
        
        if (chars.length != splits.length)
            return false;

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], splits[i]);
            } else {
                String s1 = map.get(chars[i]);
                if (!s1.equals(splits[i]))
                    return false;
            } 
        }

        Set<String> collect = map.values().stream().collect(Collectors.toSet());
        return collect.size() == map.size();
    }

    public static void main(String[] args) {
        boolean p1 = wordPattern("abba", "dog cat cat dog");
        System.out.println("p1 = " + p1);

        boolean p2 = wordPattern("abba", "dog cat cat fish");
        System.out.println("p2 = " + p2);

        boolean p3 = wordPattern("aaaa", "dog cat cat dog");
        System.out.println("p3 = " + p3);

        boolean p4 = wordPattern("abba", "dog dog dog dog");
        System.out.println("p4 = " + p4);
    }
}

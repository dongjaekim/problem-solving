import java.util.HashMap;
import java.util.Map.Entry;

class DiceGame3 {
    public static void main(String[] args) {
        int e1 = solution(2, 2, 2, 2);
        int e2 = solution(4, 1, 4, 4);
        int e3 = solution(6, 3, 3, 6);
        int e4 = solution(2, 5, 2, 6);
        int e5 = solution(6, 4, 2, 5);

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
        System.out.println("e4 = " + e4);
        System.out.println("e5 = " + e5);
    }
  
    public static int solution(int a, int b, int c, int d) {
        int answer = 0;
        HashMap<Integer, Integer> diceCount = new HashMap<>();

        diceCount.put(a, diceCount.getOrDefault(a, 0) + 1);
        diceCount.put(b, diceCount.getOrDefault(b, 0) + 1);
        diceCount.put(c, diceCount.getOrDefault(c, 0) + 1);
        diceCount.put(d, diceCount.getOrDefault(d, 0) + 1);

        int max = 0;
        for (int count : diceCount.values()) {
            max = Math.max(max, count);
        }

        if (max == 1) {
            answer = Math.min(a, Math.min(b, Math.min(c, d)));
        } else if (max == 2) {
            if (diceCount.keySet().size() == 2) {
                int p = 0;
                int q = 0;
                for (Integer i : diceCount.keySet()) {
                    if (p != 0)
                        q = i;
                    else 
                        p = i;
                }
                answer = (p + q) * Math.abs(p - q);
            } else {
                answer = diceCount.entrySet().stream()
                    .filter(e -> e.getValue() != 2)
                    .mapToInt(Entry::getKey)
                    .reduce((p, q) -> p * q)
                    .getAsInt();
            } 
        } else if (max == 3) {
            int p = 0;
            int q = 0;
            for (Entry<Integer, Integer> entry : diceCount.entrySet()) {
                if (entry.getValue() == 3) {
                    p = entry.getKey();
                } else {
                    q = entry.getKey();
                }
            }
            answer = (int) Math.pow(10 * p + q, 2);
        } else {
            answer = a * 1111;
        }

        return answer;
    }
}

package problems;

import util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class bucketPlace {

    public static boolean solution1(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']'))
                return false;

            if (c == ')') {
                if (stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (c == '}') {
                if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if (c == ']') {
                if (stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static int[] solution2(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        for (int number : numbers)
            stack.push(number);

        int add = 0;
        for (int i = answer.length - 1; i >= 0; i--) {
            int subAdd = stack.pop() + add;
            if (i == answer.length - 1)
                subAdd += 1;

            if (subAdd >= 10) {
                add = 1;
                answer[i] = subAdd - 10;
            } else {
                add = 0;
                answer[i] = subAdd;
            }
        }

        if (answer[0] == 0) {
            answer = new int[numbers.length + 1];
            answer[0] = 1;
        }

        return answer;
    }

    public static int solution3(int[] numbers) {
        int answer = 0;
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + reverse(numbers[j]) == numbers[j] + reverse(numbers[i]))
                    answer++;
            }
        }

        return answer % (10^9 + 7);
    }

    public static int reverse(int num) {
        int reverseNum = 0;
        while (num != 0) {
            reverseNum = reverseNum * 10 + num % 10;
            num /= 10;
        }

        System.out.println("reverseNum = " + reverseNum);
        return reverseNum;
    }

    public static List<Boolean> solution4(String[] inputs, String pattern) {
        List<Boolean> answer = new ArrayList<>();

        for (String input : inputs)
            answer.add(isSamePattern(input, pattern));

        return answer;
    }

    public static Boolean isSamePattern(String input, String pattern) {
//        int inputIdx = 0;
        System.out.println("input = " + input);
        for (int i = 0; i < pattern.length(); i++) {
            int index = input.indexOf(pattern.charAt(i));
            if (index == -1)
                return false;
//            System.out.println("inputIdx = " + inputIdx);
            System.out.println("index = " + index);
//            if (inputIdx <= index) {
                for (int j = 0; j < index; j++) {
                    if (Character.isUpperCase(input.charAt(j)))
                        return false;
                }
//            }

            input = input.substring(index + 1);
            System.out.println("input = " + input);
        }

        return true;
    }

    public static int solution5(int[][] coins) {
        int answer = 0;
        int m = coins.length;
        int n = coins[0].length;

        return dfs(coins, 0, 0, 0, n - 1);
    }

    private static final int[] directions = {-1, 0, 1};
    public static int dfs(int[][] coins, int r1, int c1, int r2, int c2) {
        int output = 0;
        int m = coins.length;
        int n = coins[0].length;

        if (r1 == m || r2 == m)
            return output;

        output += coins[r1][c1] + coins[r2][c2];

        int max = 0;
        for (int i = 0; i < 3; i++) {
            int c1_next = c1 + directions[i];
            if (c1_next < 0 || c1_next >= n)
                continue;

            for (int j = 0; j < 3; j++) {
                int c2_next = c2 + directions[j];
                if (c2_next < 0 || c2_next >= n || c1_next == c2_next)
                    continue;
                max = Math.max(dfs(coins, r1 + 1, c1_next, r2 + 1, c2_next), max);
            }
        }

        return output + max;
    }

    public static void main(String[] args) {
//        String p1e1 = "([]){}";
//        System.out.println("solution1(p1e1) = " + solution1(p1e1));
//
//        String p1e2 = "[(]){}";
//        System.out.println("solution1(p1e2) = " + solution1(p1e2));
//
//        String p1e3 = "])}";
//        System.out.println("solution1(p1e3) = " + solution1(p1e3));


//        int[] p2e1 = {2, 2, 0, 3};
//        System.out.println("ArrayUtils.Array1DToString(solution2(p2e1)) = " + ArrayUtils.Array1DToString(solution2(p2e1)));
//
//        int[] p2e2 = {1, 9};
//        System.out.println("ArrayUtils.Array1DToString(solution2(p2e2)) = " + ArrayUtils.Array1DToString(solution2(p2e2)));
//
//        int[] p2e3 = {9, 9, 9, 9};
//        System.out.println("ArrayUtils.Array1DToString(solution2(p2e3)) = " + ArrayUtils.Array1DToString(solution2(p2e3)));

        int[] p3e3 = {42, 97, 13, 24, 1, 76, 250};
        System.out.println("solution3(p3e3) = " + solution3(p3e3));

//        String[] p4e1 = {"BucketPlace", "BucketList", "BucketPizza"};
//        System.out.println("solution4(p4e1, \"BP\") = " + solution4(p4e1, "BP"));
//
//        String p4e2 = "BucketPlace";
//        System.out.println("isSamePattern(p4e2, \"BP\") = " + isSamePattern(p4e2, "BP"));
//
//        String p4e3 = "BucDketPlaceBP";
//        System.out.println("isSamePattern(p4e3, \"BP\") = " + isSamePattern(p4e3, "BP"));

//        int[][] p5e1 = {{4, 0, 1}, {3, 6, 2}, {5, 7, 7}, {4, 2, 2}};
//        System.out.println("solution5(p5e1) = " + solution5(p5e1));
    }
}

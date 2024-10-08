package problems.hard;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P1381DesignAStackWithIncrementOperation {
    public static void main(String[] args) {
        CustomStack stk = new CustomStack(3); // Stack is Empty []
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
        stk.increment(5, 100);                // stack becomes [101, 102, 103]
        stk.increment(2, 100);                // stack becomes [201, 202, 103]
        stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
        stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
        stk.pop();                            // return -1 --> Stack is empty return -1.
    }

    static class CustomStack {

        int[] stack;
        int idx;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            Arrays.fill(stack, -1);
            idx = -1;
            print("initialize");
        }

        public void push(int x) {
            int next = idx + 1;

            if (next < stack.length) {
                stack[next] = x;
                idx = next;
            }

            print("push");
        }

        public int pop() {
            int next = idx - 1;

            if (idx < 0) {
                return -1;
            } else {
                int val = stack[idx];
                stack[idx] = -1;
                idx = next;
                print("pop");

                return val;

            }
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, stack.length); i++)
                stack[i] = stack[i] + val;
            print("increment");
        }

        public void print(String methodName) {
            System.out.print(methodName + ": [");
            String collect = Arrays.stream(stack).mapToObj(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect + "]");
        }
    }
}

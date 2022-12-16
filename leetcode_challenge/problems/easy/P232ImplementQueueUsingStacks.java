package problems.easy;

import java.util.Stack;

public class P232ImplementQueueUsingStacks {
    static class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> temp;

        public MyQueue() {
            stack = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            int pop = 0;

            while (!stack.isEmpty())
                temp.push(stack.pop());

            pop = temp.pop();
            while (!temp.isEmpty())
                stack.push(temp.pop());

            return pop;
        }

        public int peek() {
            int peek = 0;

            while (!stack.isEmpty())
                temp.push(stack.pop());

            peek = temp.peek();
            while (!temp.isEmpty())
                stack.push(temp.pop());

            return peek;
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

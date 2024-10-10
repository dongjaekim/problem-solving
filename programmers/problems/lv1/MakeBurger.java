import java.util.*;

class MakeBurger {
    public static void main(String[] args) {
        int e1 = solution(new int[] { 2, 1, 1, 2, 3, 1, 2, 3, 1 });
        int e2 = solution(new int[] { 1, 3, 2, 1, 2, 1, 3, 1, 2 });

        System.out.println("e1 = " + e1); //2
        System.out.println("e2 = " + e2); //0
    }

    public static int solution7(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        String temp = "";
        for (int i : ingredient) {
            temp += i;

            if (temp.equals("1231")) {
                temp = "";
                stack.pop();
                stack.pop();
                stack.pop();

                List<Integer> tempStack = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    if (!stack.empty()) {
                        tempStack.add(stack.pop());
                    }
                }
                answer++;

                for (int j = tempStack.size() - 1; j >= 0; j--) {
                    stack.push(tempStack.get(j));
                    temp += tempStack.get(j);
                }
                System.out.println("matched and then temp = " + temp);
            } else {
                stack.push(i);
                if (temp.length() == 4) {
                    temp = temp.substring(1);
                }
            }
            System.out.println("stack = " + stack);
        }

        return answer;
    }
    
    public int bestSolution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}

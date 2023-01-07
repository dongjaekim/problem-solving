package problems.medium;

public class P134GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int sum = 0;
        int total = 0;
        int output = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                total += sum;
                sum = 0;
                output = i + 1;
            }
        }
        total += sum;
        return total < 0 ? -1 : output;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;

        int max = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (max < gas[i] - cost[i]) {
                max = gas[i] - cost[i];
                idx = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int tank = 0;
            boolean isCompleted = true;

            for (int j = 0; j < n; j++) {
                int temp = (j + i + idx) % n;
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                System.out.println("temp = " + temp);
                tank += gas[temp];
                System.out.println("tank = " + tank);
                System.out.println("cost[temp] = " + cost[temp]);
                if (tank < cost[temp]) {
                    isCompleted = false;
                    break;
                }
                tank -= cost[temp];
            }

            if (isCompleted)
                return (idx + i) % n;
        }

        return -1;
    }

    public static void main(String[] args) {
        int p1 = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println("p1 = " + p1);

        int p2 = canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        System.out.println("p2 = " + p2);
    }
}

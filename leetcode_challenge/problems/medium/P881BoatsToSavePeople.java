package problems.medium;

import java.util.Arrays;

public class P881BoatsToSavePeople {
  public static void main(String[] args) {
        int e1 = numRescueBoats(new int[] { 1, 2 }, 3); //1
        int e2 = numRescueBoats(new int[] { 3, 2, 2, 1 }, 3); //3
        int e3 = numRescueBoats(new int[] { 3, 5, 3, 4 }, 5); //4

        System.out.println("e1 = " + e1);
        System.out.println("e2 = " + e2);
        System.out.println("e3 = " + e3);
    }

    public static int numRescueBoats(int[] people, int limit) {
        int cnt = 0;

        int i = 0;
        int j = people.length - 1;

        Arrays.sort(people);
        // 3 5 3 4 -> 3 3 4 5
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;

            cnt++;
        }

        return cnt;
    }
}

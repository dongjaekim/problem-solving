package problems.easy;

public class P26RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;

        int prevNum = nums[0];
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prevNum != nums[i]) {
                nums[idx] = nums[i];
                prevNum = nums[i];
                idx++;
            }
        }

        return idx;
    }

    public static void main(String[] args) {
        int p1 = removeDuplicates(new int[]{1, 1, 2});
        System.out.println("p1 = " + p1);

        int p2 = removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("p2 = " + p2);
    }
}

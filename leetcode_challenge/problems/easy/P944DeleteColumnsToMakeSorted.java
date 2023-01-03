package problems.easy;

public class P944DeleteColumnsToMakeSorted {
    public static int minDeletionSize(String[] strs) {
        int output = 0;

        for (int col = 0; col < strs[0].length(); col++) {
            char prevChar = strs[0].charAt(col);;
            for (int row = 1; row < strs.length; row++) {
                int val = strs[row].charAt(col) - prevChar;
                if (val < 0) {
                    output++;
                    break;
                }
                prevChar = strs[row].charAt(col);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int p1 = minDeletionSize(new String[]{"cba", "daf", "ghi"});
        System.out.println("p1 = " + p1);

        int p2 = minDeletionSize(new String[]{"a", "b"});
        System.out.println("p2 = " + p2);

        int p3 = minDeletionSize(new String[]{"zyx", "wvu", "tsr"});
        System.out.println("p3 = " + p3);
    }
}

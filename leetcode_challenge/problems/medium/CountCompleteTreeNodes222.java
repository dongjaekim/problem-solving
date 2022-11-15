package problems.medium;

public class CountCompleteTreeNodes222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int countNodes(TreeNode root) {
        int output = 0;

        if (root == null)
            return 0;
        else
            output++;

        if (root.left != null)
            output += countNodes(root.left);
        if (root.right != null)
            output += countNodes(root.right);

        return output;
    }

    public static void main(String[] args) {
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode six = new TreeNode(6, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode four = new TreeNode(4, eight, null);
        TreeNode three = new TreeNode(3, six, seven);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);

        int p1 = countNodes(one);
        System.out.println("p1 = " + p1);
    }

}

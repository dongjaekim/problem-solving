package problems.hard;

import util.TreeNodeUtils;

import static util.TreeNodeUtils.*;

public class P124BinaryTreeMaximumPathSum {
    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int leftMax = dfs(node.left);
        int rightMax = dfs(node.right);
        int pathMax = leftMax + rightMax + node.val;
        int currentMax = Math.max(Math.max(leftMax, rightMax) + node.val, node.val);

        max = Math.max(max, Math.max(currentMax, pathMax));

        return currentMax;
    }

    public static void main(String[] args) {
        TreeNode p1n2 = new TreeNode(2);
        TreeNode p1n3 = new TreeNode(3);
        TreeNode p1n1 = new TreeNode(1, p1n2, p1n3);
        int p1 = maxPathSum(p1n1);
        System.out.println("p1 = " + p1);
        max = Integer.MIN_VALUE;

        TreeNode p2n15 = new TreeNode(15);
        TreeNode p2n7 = new TreeNode(7);
        TreeNode p2n20 = new TreeNode(20, p2n15, p2n7);
        TreeNode p2n9 = new TreeNode(9);
        TreeNode p2n_10 = new TreeNode(-10, p2n9, p2n20);
        int p2 = maxPathSum(p2n_10);
        System.out.println("p2 = " + p2);
        max = Integer.MIN_VALUE;

        TreeNode p3n_1 = new TreeNode(-1);
        TreeNode p3n_2 = new TreeNode(-2);
        TreeNode p3n2 = new TreeNode(2, p3n_1, p3n_2);
        int p3 = maxPathSum(p3n2);
        System.out.println("p3 = " + p3);
        max = Integer.MIN_VALUE;
    }
}

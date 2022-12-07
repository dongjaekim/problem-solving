package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class P938RangeSumOfBST {

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        if (root.val >= low && root.val <= high)
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        if (root.val < low)
            return rangeSumBST(root.right, low, high);
        else
            return rangeSumBST(root.left, low, high);
    }


    public static void main(String[] args) {
        TreeNode p1node3 = new TreeNode(3);
        TreeNode p1node7 = new TreeNode(7);
        TreeNode p1node18 = new TreeNode(18);
        TreeNode p1node5 = new TreeNode(5, p1node3, p1node7);
        TreeNode p1node15 = new TreeNode(15, null, p1node18);
        TreeNode p1node10 = new TreeNode(10, p1node5, p1node15);
        int p1 = rangeSumBST(p1node10, 7, 15);
        System.out.println("p1 = " + p1);

        TreeNode p2node1 = new TreeNode(1);
        TreeNode p2node6 = new TreeNode(6);
        TreeNode p2node3 = new TreeNode(3, p2node1, null);
        TreeNode p2node7 = new TreeNode(7, p2node6, null);
        TreeNode p2node13 = new TreeNode(13);
        TreeNode p2node18 = new TreeNode(18);
        TreeNode p2node5 = new TreeNode(5, p2node3, p2node7);
        TreeNode p2node15 = new TreeNode(15, p2node13, p2node18);
        TreeNode p2node10 = new TreeNode(10, p2node5, p2node15);
        int p2 = rangeSumBST(p2node10, 6, 10);
        System.out.println("p2 = " + p2);
    }

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
}

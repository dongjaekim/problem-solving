package problems.medium;

import util.TreeNodeUtils;

import static util.TreeNodeUtils.*;

public class P1026MaximumDifferenceBetweenNodeAndAncestor {

    public static int maxAncestorDiff(TreeNode root) {
        return traverse(root, root.val, root.val);
    }

    public static int traverse(TreeNode node, int minVal, int maxVal) {
        if (node == null)
            return 0;

        int maxDiff = Math.max(Math.abs(node.val - minVal), Math.abs(node.val - maxVal));
        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);
        return Math.max(Math.max(traverse(node.left, minVal, maxVal), traverse(node.right, minVal, maxVal)), maxDiff);
    }

    public static void main(String[] args) {
        TreeNode p1n4 = new TreeNode(4);
        TreeNode p1n7 = new TreeNode(7);
        TreeNode p1n13 = new TreeNode(13);
        TreeNode p1n1 = new TreeNode(1);
        TreeNode p1n6 = new TreeNode(6, p1n4, p1n7);
        TreeNode p1n14 = new TreeNode(14, p1n13, null);
        TreeNode p1n3 = new TreeNode(3, p1n1, p1n6);
        TreeNode p1n10 = new TreeNode(10, null, p1n14);
        TreeNode p1n8 = new TreeNode(8, p1n3, p1n10);
        int p1 = maxAncestorDiff(p1n8);
        System.out.println("p1 = " + p1);

        TreeNode p2n3 = new TreeNode(3);
        TreeNode p2n0 = new TreeNode(0, p2n3, null);
        TreeNode p2n2 = new TreeNode(2, null, p2n0);
        TreeNode p2n1 = new TreeNode(1, null, p2n2);
        int p2 = maxAncestorDiff(p2n1);
        System.out.println("p2 = " + p2);
    }
}

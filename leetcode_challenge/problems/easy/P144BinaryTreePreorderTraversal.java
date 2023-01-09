package problems.easy;

import util.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

public class P144BinaryTreePreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNodeUtils.TreeNode root) {
        List<Integer> output = new ArrayList<>();

        dfs(output, root);
        return output;
    }

    public static void dfs(List<Integer> traversal, TreeNodeUtils.TreeNode root) {
        if (root == null)
            return;

        traversal.add(root.val);
        dfs(traversal, root.left);
        dfs(traversal, root.right);

        return;
    }

    public static void main(String[] args) {
        TreeNodeUtils.TreeNode p1n3 = new TreeNodeUtils.TreeNode(3);
        TreeNodeUtils.TreeNode p1n2 = new TreeNodeUtils.TreeNode(2, p1n3, null);
        TreeNodeUtils.TreeNode p1n1 = new TreeNodeUtils.TreeNode(1, null, p1n2);
        List<Integer> p1 = preorderTraversal(p1n1);
        System.out.println("p1 = " + p1);

        List<Integer> p2 = preorderTraversal(null);
        System.out.println("p2 = " + p2);

        TreeNodeUtils.TreeNode p3n1 = new TreeNodeUtils.TreeNode(1, null, null);
        List<Integer> p3 = preorderTraversal(p3n1);
        System.out.println("p3 = " + p3);
    }
}

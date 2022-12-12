package util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class TreeNodeUtils {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String toString(TreeNode root) {
        StringJoiner joiner = new StringJoiner(", ");

        if (root == null)
            return "[]";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                joiner.add("null");
                continue;
            } else {
                joiner.add(String.valueOf(node.val));
            }

            queue.add(node.left);
            queue.add(node.right);
        }

        return "[" + joiner + "]";
    }

}

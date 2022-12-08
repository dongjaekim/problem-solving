package problems.easy;

import util.TreeNodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P872LeafSimilarTrees {
    static List<Integer> leafSequence = new ArrayList<>();

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1);
        dfs(root2);

        int leafSize = leafSequence.size() / 2;

        for (int i = 0; i < leafSize; i++) {
            if (leafSequence.get(i) != leafSequence.get(i + leafSize))
                return false;
        }
        return true;
    }

    public static void dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            leafSequence.add(node.val);
            return;
        }

        if (node.left != null)
            dfs(node.left);
        if (node.right != null)
            dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode p1t1n7 = new TreeNode(7);
        TreeNode p1t1n4 = new TreeNode(4);
        TreeNode p1t1n6 = new TreeNode(6);
        TreeNode p1t1n2 = new TreeNode(2, p1t1n7, p1t1n4);
        TreeNode p1t1n9 = new TreeNode(9);
        TreeNode p1t1n8 = new TreeNode(8);
        TreeNode p1t1n5 = new TreeNode(5, p1t1n6, p1t1n2);
        TreeNode p1t1n1 = new TreeNode(1, p1t1n9, p1t1n8);
        TreeNode p1t1n3 = new TreeNode(3, p1t1n5, p1t1n1);

        TreeNode p1t2n9 = new TreeNode(9);
        TreeNode p1t2n8 = new TreeNode(8);
        TreeNode p1t2n6 = new TreeNode(6);
        TreeNode p1t2n7 = new TreeNode(7);
        TreeNode p1t2n4 = new TreeNode(4);
        TreeNode p1t2n2 = new TreeNode(2, p1t2n9, p1t2n8);
        TreeNode p1t2n5 = new TreeNode(5, p1t2n6, p1t2n7);
        TreeNode p1t2n1 = new TreeNode(1, p1t2n4, p1t2n2);
        TreeNode p1t2n3 = new TreeNode(3, p1t2n5, p1t2n1);

        boolean p1 = leafSimilar(p1t1n3, p1t2n3);
        System.out.println("p1 = " + p1);
        leafSequence.clear();


        TreeNode p2t1n2 = new TreeNode(2);
        TreeNode p2t1n3 = new TreeNode(3);
        TreeNode p2t1n1 = new TreeNode(1, p2t1n2, p2t1n3);

        TreeNode p2t2n2 = new TreeNode(2);
        TreeNode p2t2n3 = new TreeNode(3);
        TreeNode p2t2n1 = new TreeNode(1, p2t2n3, p2t2n2);

        boolean p2 = leafSimilar(p2t1n1, p2t2n1);
        System.out.println("p2 = " + p2);
    }
}

package problems.easy;

import util.TreeNodeUtils;

import static util.TreeNodeUtils.*;

public class P100SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    public static boolean traverse(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        else if (p == null && q == null)
            return true;
        else if (p.val != q.val)
            return false;

        return traverse(p.left, q.left) && traverse(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p1t1n3 = new TreeNode(3);
        TreeNode p1t1n2 = new TreeNode(2);
        TreeNode p1t1n1 = new TreeNode(1, p1t1n2, p1t1n3);

        TreeNode p1t2n3 = new TreeNode(3);
        TreeNode p1t2n2 = new TreeNode(2);
        TreeNode p1t2n1 = new TreeNode(1, p1t1n2, p1t1n3);

        boolean p1 = isSameTree(p1t1n1, p1t2n1);
        System.out.println("p1 = " + p1);

        TreeNode p2t1n2 = new TreeNode(2);
        TreeNode p2t1n1 = new TreeNode(1, p2t1n2, null);
        TreeNode p2t2n2 = new TreeNode(2);
        TreeNode p2t2n1 = new TreeNode(1, null, p2t2n2);

        boolean p2 = isSameTree(p2t1n1, p2t2n1);
        System.out.println("p2 = " + p2);


    }

}

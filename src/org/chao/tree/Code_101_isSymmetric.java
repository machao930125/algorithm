package org.chao.tree;

/**
 * 对称二叉树
 */
public class Code_101_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }

        boolean res1 = check(left.left, right.right);
        boolean res2 = check(left.right, right.left);

        return left.val == right.val && res1 && res2;
    }

}

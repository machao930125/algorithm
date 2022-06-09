package org.chao.tree;

/**
 * 二叉树最小深度
 */
public class Code_111_minDepth {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int minL = 1;

        if (left != 0 && right != 0){
            minL += Math.min(left, right);
        }else if (left == 0){
            minL += right;
        }else {
            minL += left;
        }

        return minL;
    }
}

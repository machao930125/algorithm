package org.chao.tree;

/**
 * 二叉树最大深度
 */
public class Code_104_maxDepth {
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

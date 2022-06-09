package org.chao.tree;

/**
 * 路径总和
 */
public class Code_112_hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return targetSum == root.val;
        }
        int sum = targetSum - root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}

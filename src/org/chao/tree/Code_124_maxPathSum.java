package org.chao.tree;

/**
 * 最大路径和
 */
public class Code_124_maxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);

        int temp = left + right + root.val;

        maxSum = Math.max(temp, maxSum);

        return root.val + Math.max(left, right);
    }
}

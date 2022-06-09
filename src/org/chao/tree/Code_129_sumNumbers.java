package org.chao.tree;

/**
 * 从根节点到叶子节点数字之和
 */
public class Code_129_sumNumbers {

    public int sumNumbers(TreeNode root){
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum){
        if (root == null){
            return 0;
        }

        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null){
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }

}

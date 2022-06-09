package org.chao.tree;

/**
 * 二叉树的直径
 */
public class Code_543_diameterOfBinaryTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        return ans - 1;
    }

    public int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

}

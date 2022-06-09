package org.chao.tree;

/**
 * 验证是否是一颗二叉搜索树
 */
public class Code_098_isValidBST {

    public boolean isValidBST(TreeNode root){
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long lower, long upper){
        if (root == null){
            return true;
        }
        if (lower >= root.val || upper < root.val){
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }

}

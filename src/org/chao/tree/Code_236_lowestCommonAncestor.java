package org.chao.tree;


/**
 * 获取二叉树公共祖先
 */
public class Code_236_lowestCommonAncestor {
    private TreeNode ans;

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {return false;}
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root == p || root == q) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root == p || root == q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

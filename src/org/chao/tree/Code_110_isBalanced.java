package org.chao.tree;

/**
 * 平衡二叉树
 */
public class Code_110_isBalanced {
    class BalancedInfo{
        int length;
        boolean balance;
        public BalancedInfo(int length, boolean balance){
            this.balance = balance;
            this.length = length;
        }
    }

    public boolean isBalanced(TreeNode root) {
        BalancedInfo info = balancedInfo(root);
        return info.balance;
    }

    public BalancedInfo balancedInfo(TreeNode root){
        if (root == null){
            return new BalancedInfo(0, true);
        }
        BalancedInfo left = balancedInfo(root.left);
        BalancedInfo right = balancedInfo(root.right);
        boolean result = left.balance && right.balance && (Math.abs(left.length - right.length) <= 1);
        int length = Math.max(left.length, right.length) + 1;
        return new BalancedInfo(length, result);
    }
}

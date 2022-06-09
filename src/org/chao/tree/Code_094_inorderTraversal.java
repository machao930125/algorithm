package org.chao.tree;

import java.util.ArrayList;
import java.util.List;

public class Code_094_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans){
        if (root == null){
            return;
        }

        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }
}

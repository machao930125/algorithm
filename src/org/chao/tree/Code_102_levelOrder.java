package org.chao.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 */
public class Code_102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                level.add(node.val);
                if (null != node.left){
                    nodeQueue.offer(node.left);
                }

                if (null != node.right){
                    nodeQueue.offer(node.right);
                }
            }

            ans.add(level);

        }
        return ans;

    }
}

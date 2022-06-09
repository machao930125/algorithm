package org.chao.tree;

import org.chao.datastructure.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 锯齿层序遍历
 */
public class Code_103_zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(Tree parent){
        List<List<Integer>> ans = new LinkedList<>();
        if (parent == null){
            return ans;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(parent);
        boolean isOrderLeft = true;

        while (!queue.isEmpty()){
            Deque<Integer> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size ; i ++){
                Tree node = queue.poll();
                if (isOrderLeft){
                    level.offerLast(node.value);
                }else {
                    level.offerFirst(node.value);
                }

                if (null != node.left){
                    queue.offer(node.left);
                }

                if (null != node.right){
                    queue.offer(node.right);
                }
            }

            ans.add(new LinkedList<>(level));
            isOrderLeft = !isOrderLeft;

        }
        return ans;
    }

}

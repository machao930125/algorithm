package org.chao.datastructure.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * 1、二叉树遍历，四种遍历方法
 * 2、查找一个节点的后继节点、前驱节点
 * 3、获取二叉树的最大宽度
 * 4、获取二叉树的最大深度
 * 5、查找二叉树两个节点最大距离
 * 6、判断二叉树是否是平衡二叉树
 * 7、判断二叉树是否是搜索二叉树
 * 8、返回二叉搜索树的最大节点数
 * 9、查找二叉树两个节点的最低祖先
 */
public class TreeTest {

    @Test
    public void printTest() {
        Tree tree = Tree.initTree();
        System.out.println("\n ============前序遍历===========");
        printPre(tree);
        System.out.println("\n ============中序遍历===========");
        printIn(tree);
        System.out.println("\n ============后序遍历===========");
        printAfter(tree);
        System.out.println("\n ============按层遍历===========");
        printLevel(tree);
    }

    /**
     * 前序遍历
     *
     * @param parent
     */
    public void printPre(Tree parent) {
        if (parent == null) {
            return;
        }

        System.out.print(" " + parent.value + " ");
        printPre(parent.left);
        printPre(parent.right);
    }

    /**
     * 中序遍历
     *
     * @param parent
     */
    public void printIn(Tree parent) {
        if (parent == null) {
            return;
        }

        printIn(parent.left);
        System.out.print(" " + parent.value + " ");
        printIn(parent.right);
    }

    /**
     * 后续遍历
     *
     * @param parent
     */
    public void printAfter(Tree parent) {
        if (parent == null) {
            return;
        }

        printAfter(parent.left);
        printAfter(parent.right);
        System.out.print(" " + parent.value + " ");
    }

    /**
     * 层序遍历
     *
     * @param parent
     */
    public void printLevel(Tree parent) {
        if (parent == null) {
            return;
        }

        Queue<Tree> queue = new ArrayDeque<>(10);
        queue.add(parent);

        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.print(" " + node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    /**
     * 测试查找前驱和后继节点
     */
    @Test
    public void findTreeNodeTest() {
        Tree tree = Tree.initTree();

        System.out.println("\n ============查找前驱节点===========");
        System.out.println(findPreNode(tree.right).value);
        System.out.println("\n ============查找后继节点===========");
        System.out.println(findAfterNode(tree.right).value);

    }

    /**
     * 查找前驱节点
     *
     * @return
     */
    public Tree findPreNode(Tree node) {
        if (node == null) {
            return node;
        }

        // left -> right -> right -> right
        Tree left = node.left;
        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            return left;
        }

        // parent.left -> parent.left -> parent.left
        while (node.parent != null && node.parent.left == node) {
            node = node.parent;
        }

        return node.parent;
    }

    /**
     * 查找后继节点
     *
     * @param node
     * @return
     */
    public Tree findAfterNode(Tree node) {
        if (node == null) {
            return null;
        }

        // right -> left -> left -> left
        Tree right = node.right;
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        // parent.right -> parent.right -> parent.right
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }

        return node.parent;
    }


    @Test
    public void maxWeightTest() {
        Tree tree = Tree.initTree();

        System.out.println("二叉树最大宽度：" + maxWeight(tree));
    }


    /**
     * 获取二叉树最大宽度
     */
    public int maxWeight(Tree node) {
        if (node == null) {
            return 0;
        }

        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(node);

        Tree curEnd = node;
        int levelCount = 0;
        Tree nextEnd = null;
        int maxCount = 0;

        while (!queue.isEmpty()) {
            levelCount++;

            Tree cur = queue.poll();

            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }

            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }

            if (cur == curEnd) {
                maxCount = Math.max(maxCount, levelCount);
                levelCount = 0;
                curEnd = nextEnd;
            }
        }
        return maxCount;
    }


    /**
     * 测试获取二叉树的最大深度
     */
    @Test
    public void getMaxHeightTest() {
        Tree tree = Tree.initSearchTree();
        System.out.println("二叉树最大深度：" + getMaxHeight(tree));

        System.out.println("二叉树两个节点的最大距离：" + getMaxDis(tree).maxDis);

        System.out.println("二叉树是否是平衡二叉树：" + isBalanceTree(tree).balance);

        System.out.println("二叉树是否是搜索二叉树：" + isSearchTree(tree).search);

        SearchTreeInfo info = getMaxCountWithSearchTree(tree);
        System.out.println("二叉树是否是搜索二叉树: " + info.search + ", 是搜索二叉树最大节点数：" + info.maxCount);

        System.out.println("二叉树查找两个节点公共祖先：" + lowestCommonNode(tree, tree.left.left, tree.left.right).value);
    }


    /**
     * 获取二叉树的最大深度
     *
     * @param node
     * @return
     */
    public int getMaxHeight(Tree node) {
        if (node == null) {
            return 0;
        }

        int left = getMaxHeight(node.left);
        int right = getMaxHeight(node.right);

        // 当前节点最大深度
        int height = Math.max(left, right) + 1;

        return height;
    }

    /**
     * 获取二叉树两个节点的最大距离
     */
    static class DisInfo {
        int maxDis;
        int height;

        public DisInfo(int maxDis, int height) {
            this.maxDis = maxDis;
            this.height = height;
        }
    }

    public DisInfo getMaxDis(Tree node) {
        if (node == null) {
            return new DisInfo(0, 0);
        }

        DisInfo left = getMaxDis(node.left);
        DisInfo right = getMaxDis(node.right);

        int nodeDis = Math.max(left.maxDis, right.maxDis);
        int maxDis = Math.max(left.height + right.height + 1, nodeDis);

        return new DisInfo(maxDis, Math.max(left.height, right.height) + 1);
    }


    /**
     * 判断是否是平衡二叉树(检查左右两个节点高度差不超过1)
     */
    static class BalanceTreeInfo {
        boolean balance;
        int height;

        public BalanceTreeInfo(boolean balance, int height) {
            this.balance = balance;
            this.height = height;
        }
    }

    public BalanceTreeInfo isBalanceTree(Tree node) {
        if (node == null) {
            return new BalanceTreeInfo(true, 0);
        }

        BalanceTreeInfo left = isBalanceTree(node.left);
        BalanceTreeInfo right = isBalanceTree(node.right);

        boolean balance = left.balance && right.balance && Math.abs(left.height - right.height) <= 1;

        return new BalanceTreeInfo(balance, Math.max(left.height, right.height) + 1);
    }


    /**
     * 判断一棵树是否是一颗搜索二叉树（左节点均小于右节点）
     */
    static class SearchTreeInfo {
        boolean search;
        int maxValue;
        int minValue;
        int maxCount;

        public SearchTreeInfo(boolean search, int maxValue, int minValue) {
            this.search = search;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }

        public SearchTreeInfo(boolean search, int maxValue, int minValue, int maxCount) {
            this.search = search;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.maxCount = maxCount;
        }
    }

    public SearchTreeInfo isSearchTree(Tree node) {
        if (node == null) {
            return new SearchTreeInfo(true, 0, 0);
        }

        SearchTreeInfo left = isSearchTree(node.left);
        SearchTreeInfo right = isSearchTree(node.right);

        boolean search = left.search && right.search && node.value > left.maxValue && node.value < right.minValue;

        return new SearchTreeInfo(search,
                Math.max(Math.max(left.maxValue, right.maxValue), node.value),
                Math.min(Math.min(left.minValue, right.minValue), node.value));

    }


    /**
     * 获取二叉树最大节点数
     *
     * @param node
     * @return
     */
    public SearchTreeInfo getMaxCountWithSearchTree(Tree node) {
        if (node == null) {
            return new SearchTreeInfo(true, 0, 0, 0);
        }

        SearchTreeInfo left = isSearchTree(node.left);
        SearchTreeInfo right = isSearchTree(node.right);

        boolean search = left.search && right.search && node.value < right.minValue && node.value > left.maxValue;
        int maxCount = 0;
        if (search) {
            maxCount = left.maxCount + right.maxCount + 1;
        } else {
            maxCount = Math.max(left.maxCount, right.maxCount);
        }

        return new SearchTreeInfo(search,
                Math.max(Math.max(left.maxValue, right.maxValue), node.value),
                Math.min(Math.min(left.minValue, right.minValue), node.value),
                maxCount);
    }

    /**
     * 查找二叉树两个节点公共祖先
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public Tree lowestCommonNode(Tree root, Tree node1, Tree node2) {
        if (root == null) {
            return null;
        }

        if (node1 == root || node2 == root) {
            return root;
        }

        Tree left = lowestCommonNode(root.left, node1, node2);
        Tree right = lowestCommonNode(root.right, node1, node2);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }


}

package org.chao.datastructure.tree;

/**
 * 二叉树
 */
public class Tree {
    public int value;
    public Tree left;
    public Tree right;
    public Tree parent;

    public Tree(int value) {
        this.value = value;
    }


    /**
     * 初始化满二叉树
     *
     * @return
     */
    public static Tree initTree() {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        Tree tree8 = new Tree(8);
        Tree tree9 = new Tree(9);
        Tree tree10 = new Tree(10);
        Tree tree11 = new Tree(11);

        tree1.left = tree2;
        tree2.parent = tree1;
        tree1.right = tree3;
        tree3.parent = tree2;
        tree2.left = tree4;
        tree4.parent = tree2;
        tree2.right = tree5;
        tree5.parent = tree2;
        tree3.left = tree6;
        tree6.parent = tree3;
        tree3.right = tree7;
        tree7.parent = tree3;
        tree4.left = tree8;
        tree8.parent = tree4;
        tree4.right = tree9;
        tree9.parent = tree4;
        tree5.left = tree10;
        tree10.parent = tree5;
        tree10.right = tree11;

        return tree1;
    }

    /**
     * 初始化搜索二叉树
     *
     * @return
     */
    public static Tree initSearchTree() {
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        Tree tree5 = new Tree(5);
        Tree tree6 = new Tree(6);
        Tree tree7 = new Tree(7);
        Tree tree8 = new Tree(8);

        tree4.left = tree2;
        tree4.right = tree6;
        tree2.left = tree1;
        tree2.right = tree3;
        tree6.left = tree5;
        tree6.right = tree8;
        tree8.right = tree7;
        return tree4;
    }
}
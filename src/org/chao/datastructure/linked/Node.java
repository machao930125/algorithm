package org.chao.datastructure.linked;

/**
 * 链表节点，双向链表
 */
public class Node {
    public int value;
    public Node next;
    public Node pre;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 提供测试数据
     *
     * @return
     */
    public static Node initNodeList(int type) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(2);
        Node node9 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        if (type == 1) {
            node7.next = node5;
        }else if (type == 2){
            node7.next = node8;
            node8.next = node9;
        }
        return node1;
    }





    public static void print(Node node){
        StringBuilder builder = new StringBuilder();

        while (node != null){
            builder.append("node:" + node.value + ", ");
            node = node.next;
        }

        System.out.println(builder.toString());
    }
}

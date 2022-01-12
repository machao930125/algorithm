package org.chao.datastructure.linked;

import org.junit.jupiter.api.Test;


/**
 * 1、寻找某一个值的节点数量
 * 2、寻找中间节点
 * 3、判断链表是否有环
 * 4、删除链表某个节点
 * 5、合并两个链表
 * 6、翻转链表
 * 7、K个一组翻转链表
 */
public class NodeTest {
    /**
     * 1、寻找某一个值的节点数量
     */
    @Test
    public void findNodeByValueTest() {
        int value = 2;
        Node node = Node.initNodeList(2);

        int count = 0;
        while (node != null) {
            if (node.value == value) {
                count++;
            }
            node = node.next;
        }

        System.out.println(count);
    }


    /**
     * 2、寻找中间节点
     */
    @Test
    public void findMidNodeTest() {
        Node node = Node.initNodeList(2);
        Node fastNode = node;
        Node slowNode = node;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        System.out.println(slowNode.value);
    }


    /**
     * 3、判断链表是否有环
     */
    @Test
    public void findCircleTest() {
        Node node = Node.initNodeList(1);
        Node fastNode = node;
        Node slowNode = node;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                System.out.println("链表中存在环。。。");
                return;
            }
        }
        System.out.println("链表中无环。。。");
    }


    /**
     * 4、删除链表某个节点
     */
    @Test
    public void deleteNodeByValueTest() {
        Node node = Node.initNodeList(2);
        int value = 3;

        Node head = node;
        Node preNode = null;
        while (node != null) {
            if (node.value == value) {
                if (head == node) {
                    node = node.next;
                    head.next = null;
                    head = node;
                } else {
                    preNode.next = node.next;
                    node.next = null;
                    node = preNode.next;
                }
            } else {
                preNode = node;
                node = node.next;
            }

        }

        Node.print(head);
    }


    /**
     * 5、合并两个链表
     */
    @Test
    public void merge2LinkedTest() {
        Node node1 = Node.initNodeList(3);
        Node node2 = Node.initNodeList(3);

        Node head = new Node(0);
        Node cur = head;

        while (node1 != null && node2 != null) {
            if (node1.value < node2.value) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }

        cur.next = node1 == null ? node2 : node1;

        Node.print(head.next);
    }


    /**
     * 6、翻转链表
     */
    @Test
    public void revertLinked() {
        Node cur = Node.initNodeList(3);

        Node pre = null;
        Node temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        Node.print(pre);
    }



    @Test
    public void reverseKGroupTest(){
        Node node = Node.initNodeList(2);
        Node result = reverseKGroup(node, 3);

        Node.print(result);
    }

    /**
     * 链表K个一组进行翻转
     *
     * @param head
     * @param k
     * @return
     */
    public Node reverseKGroup(Node head, int k){
        if (head == null) return null;
        // 区间 [start, end) 包含 k 个待反转元素
        Node start, end;
        start = end = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (end == null) return head;
            end = end.next;
        }
        // 反转前 k 个元素
        Node newHead = revertNode(start, end);
        // 递归反转后续链表并连接起来
        start.next = reverseKGroup(end, k);
        return newHead;
    }


    private Node revertNode(Node start, Node end){
        if (start == null){
            return null;
        }

        Node pre = null;
        Node temp;

        while (start != end){
            temp = start.next;
            start.next = pre;
            pre = start;
            start = temp;
        }

        return pre;
    }


}

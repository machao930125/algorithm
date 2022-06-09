package org.chao.datastructure.linked;

import org.junit.jupiter.api.Test;


/**
 * 1、寻找某一个值的节点数量
 * 2、寻找中间节点
 * 3、判断链表是否有环
 * 4、删除链表某个节点
 * 5、合并两个链表
 * 6、翻转链表
 * 7、判断两个链表是否相交，返回交点
 * 8、K个一组翻转链表
 * 9、删除重复节点
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

    /**
     * 7、获取两个链表交点
     */
    @Test
    public void getIntersectionNode(){
        Node headA = Node.initNodeList(3);
        Node headB = Node.initNodeList(3);

        Node A = headA;
        Node B = headB;

        while (A!= B ){
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }

        System.out.println(A);

    }



    @Test
    public void reverseKGroupTest(){
        Node node = Node.initNodeList(2);
        Node result = reverseKGroup(node, 3);

        Node.print(result);
    }

    /**
     * 合并k 个链表
     *
     * @param lists
     * @return
     */
    public Node mergeKLists(Node[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public Node merge(Node[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public Node mergeTwoLists(Node a, Node b) {
       if (a == null || b == null){
           return a != null ? a: b;
       }

        Node dummy = new Node(-1);

       Node cur = dummy;

       while (a!= null && b != null){
           if (a.value < b.value){
               cur.next = a;
               a = a.next;
           }else {
               cur.next = b;
               b = b.next;
           }
           cur = cur.next;
       }

       if (a == null){
           cur.next = b;
       }else {
           cur.next = a;
       }

       return dummy.next;
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

    /**
     * 删除重复节点
     *
     * @param head
     * @return
     */
    public Node deleteDuplicates(Node head){
        if (head == null){
            return null;
        }

        Node cur = head;
        while (cur.next != null){
            if (cur.value == cur.next.value){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;
    }

}

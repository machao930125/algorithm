package org.chao.leetcode;

import org.chao.datastructure.linked.Node;

public class Code_024_SwapPairs {
    public Node swapPairs(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node cur = dummy;

        while (cur.next != null && cur.next.next != null){
            Node node1 = cur.next;
            Node node2 = cur.next.next;

            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;

        }

        return dummy.next;

    }

}

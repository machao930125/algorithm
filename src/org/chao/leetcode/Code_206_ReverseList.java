package org.chao.leetcode;

import org.chao.datastructure.linked.Node;

/**
 * 翻转链表
 */
public class Code_206_ReverseList {

    public Node reverseList(Node head){
        Node pre = null;
        Node temp;

        while (head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;

    }

}

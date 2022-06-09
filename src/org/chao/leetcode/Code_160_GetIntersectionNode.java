package org.chao.leetcode;

import org.chao.datastructure.linked.Node;

/**
 * 判断两个链表是否有焦点，返回焦点node
 */
public class Code_160_GetIntersectionNode {
    public Node getIntersectionNode(Node headA, Node headB) {
        Node A = headA;
        Node B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

}

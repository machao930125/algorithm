package org.chao.linked;

/**
 * 两两交换链表中的节点
 */
public class Code_024_swapPairs {
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null){
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;

            node1.next = node2.next;
            pre.next = node2;
            node2.next = node1;
            pre = node1;
        }
        return dummy.next;
    }
}

package org.chao.linked;

/**
 * 奇偶链表
 */
public class Code_328_oddEvenList {
    public ListNode oddEvenList(ListNode head){
        if (head == null){
            return null;
        }

        ListNode head2 = head.next;
        ListNode cur1 = head;
        ListNode cur2 = head2;
        while (cur2 != null && cur2.next != null){
            cur1.next = cur2.next;
            cur1 = cur1.next;
            cur2.next = cur1.next;
            cur2 = cur2.next;
        }

        cur1.next = head2;
        return head;
    }
}

package org.chao.linked;

/**
 * K个一组翻转链表
 */
public class Code_025_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null){
                    return dummy.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] nodes = reverseNode(head, tail);
            head = nodes[0];
            tail = nodes[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    public ListNode[] reverseNode(ListNode head, ListNode tail){
        ListNode end = tail.next;
        ListNode cur = head;
        while (tail != end){
            ListNode temp = cur.next;
            cur.next = end;
            end = cur;
            cur = temp;
        }

        return new ListNode[]{tail, head};
    }

}

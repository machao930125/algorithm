package org.chao.linked;

/**
 * 查找链表第一个入环节点
 */
public class Code_142_detectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast){
                ListNode node = head;
                while (node != slow){
                    node = node.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

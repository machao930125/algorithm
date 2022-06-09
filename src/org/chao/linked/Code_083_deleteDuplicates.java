package org.chao.linked;

/**
 * 删除链表中重复元素
 */
public class Code_083_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        if (head == null){
            return null;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}

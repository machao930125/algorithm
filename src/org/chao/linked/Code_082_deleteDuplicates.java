package org.chao.linked;

/**
 * 删除链表中重复元素
 */
public class Code_082_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if (cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && x == cur.next.val) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

}

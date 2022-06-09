package org.chao.linked;

/**
 * 插入排序
 */
public class Code_147_insertionSortList {

    public ListNode insertionSortList(ListNode head){
        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode last = head;
        ListNode cur = last.next;

        while (cur != null){
            if (last.val < cur.val){
                last = last.next;
            }else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val){
                    pre = pre.next;
                }

                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }

            cur = last.next;
        }

        return dummy.next;
    }





























}

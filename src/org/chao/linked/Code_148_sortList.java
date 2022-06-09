package org.chao.linked;

public class Code_148_sortList {

    public ListNode sortList(ListNode head){
        return sort(head, null);
    }

    public ListNode sort(ListNode head, ListNode tail){
        if (head == null){
            return null;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode list1 = sort(head, slow);
        ListNode list2 = sort(slow, tail);

        return merge(list1, list2);
    }

    public ListNode merge(ListNode l1 , ListNode l2){
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

}

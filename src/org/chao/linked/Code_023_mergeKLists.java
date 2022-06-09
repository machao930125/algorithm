package org.chao.linked;

/**
 * 合并k个有序列表
 */
public class Code_023_mergeKLists {
    public ListNode mergeKLists(ListNode[] lists){
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if (left > right){
            return null;
        }
        if (left == right){
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);

        return mergeTwo(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwo(ListNode a, ListNode b){
        if (a == null || b == null){
            return a == null ? b: a;
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val){
                cur.next = a;
                a = a.next;
            }else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        cur.next = a == null ? b: a;
        return dummy.next;
    }

}

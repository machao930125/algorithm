package org.chao.linked;

/**
 * 合并两个有序链表
 */
public class Code_021_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;

        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2:list1;
        return dummyNode.next;
    }

}

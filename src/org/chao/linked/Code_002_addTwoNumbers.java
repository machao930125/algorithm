package org.chao.linked;

public class Code_002_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;
        while (l1 != null || l2 != null || add > 0) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;

            int sum = n1 + n2 + add;
            add = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }
        return dummyNode.next;
    }



















}

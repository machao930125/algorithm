package org.chao.linked;

/**
 * 分隔链表
 */
public class Code_088_partition {
    public ListNode partition(ListNode head, int x){
       ListNode smallDummy = new ListNode();
       ListNode largeDummy = new ListNode();
       ListNode small = smallDummy;
       ListNode large = largeDummy;

       while (head != null){
           if (head.val < x){
               small.next = head;
               small = small.next;
           }else {
               large.next = head;
               large = large.next;
           }
           head = head.next;
       }
       small.next = largeDummy.next;
       largeDummy.next = null;
       return smallDummy.next;
    }
}

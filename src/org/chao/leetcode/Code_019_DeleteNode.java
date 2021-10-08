package org.chao.leetcode;

/**
 * 双指针、链表
 */
public class Code_019_DeleteNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        // 1 2
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slowNode = head;
            ListNode fastNode = head;
            while (fastNode != null){
                fastNode = fastNode.next;
                if (fastNode == null){
                    break;
                }
                n --;
                if (n < 0){
                    slowNode = slowNode.next;
                }
            }
            slowNode.next = slowNode.next.next;
            return head;
        }
    }
}


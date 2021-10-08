package org.chao.leetcode;

/**
 * 双指针、链表
 */
public class Code_876_MiddleNode {
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
        // 1 2 3 4 5
        public ListNode middleNode(ListNode head) {
            ListNode slowNode = head;
            ListNode fastNode = head.next;
            while (fastNode != null && fastNode.next != null){
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
            return fastNode == null ? slowNode : slowNode.next;
        }
    }
}

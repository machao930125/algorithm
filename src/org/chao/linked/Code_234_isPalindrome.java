package org.chao.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断链表是否是回文链表
 */
public class Code_234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            list.add(head);
            head = head.next;
        }
        int i = 0 ;int j = list.size() - 1;

        while (i < j){
            if (list.get(i).val != list.get(j).val){
                return false;
            }
            i ++;
            j --;
        }

        return true;

    }
}

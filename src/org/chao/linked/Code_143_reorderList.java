package org.chao.linked;

import java.util.ArrayList;
import java.util.List;

public class Code_143_reorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int i = 0; int j = list.size() - 1;
        cur = head;
        while (i < j){
            cur.next = list.get(j--);
            cur = cur.next;
            if (i == j){
                break;
            }
            cur.next = list.get(++i);
            cur = cur.next;
        }
        cur.next = null;
        return;
    }
}

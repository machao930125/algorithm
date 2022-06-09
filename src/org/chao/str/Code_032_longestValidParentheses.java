package org.chao.str;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 */
public class Code_032_longestValidParentheses {

    public int longestValidParentheses(String s){
        int l =0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else {
                    l = Math.max(l, i - stack.peek());
                }
            }
        }
        return l;
    }
}

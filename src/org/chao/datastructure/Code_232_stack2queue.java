package org.chao.datastructure;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class Code_232_stack2queue {

    class MyQueue{
        Stack<Integer> data;
        Stack<Integer> temp;

        public MyQueue() {
            data = new Stack<>();
            temp = new Stack<>();
        }

        public void push(int x) {
            while (!data.isEmpty()){
                temp.push(data.pop());
            }
            data.push(x);
            while (!temp.isEmpty()){
                data.push(temp.pop());
            }
        }

        public int pop() {
            return data.pop();
        }

        public int peek() {
            return data.peek();
        }

        public boolean empty() {
            return data.isEmpty();
        }
    }
}

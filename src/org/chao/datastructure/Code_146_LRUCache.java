package org.chao.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU
 */
public class Code_146_LRUCache {
    // 双链表
    class DLinkedNode{
        int val;
        int key;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    // 定义LRU所需要属性
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    // 构造器
    public Code_146_LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if ( node == null){
            return -1;
        }

        removeNode(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int val){
        DLinkedNode node = cache.get(key);
        if (node == null){
            node = new DLinkedNode(key, val);
            // 数量多大移除尾节点
            addHead(node);
            cache.put(key, node);
            size ++;
            if (size > capacity){
                DLinkedNode delNode = removeTailNode();
                size --;
                cache.remove(delNode.key);
            }
            return;
        }

        removeNode(node);
        addHead(node);
        node.val = val;
    }



    // 辅助 移除节点和添加到头节点
    public void addHead(DLinkedNode node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
    public void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    public DLinkedNode removeTailNode(){
        DLinkedNode node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        return node;
    }




}

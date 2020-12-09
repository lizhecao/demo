package com.test.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 李哲操
 * @create: 2020-04-05 21:39
 **/
class LFUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private int num;
    private Node head;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            return getAndMove(key).getValue();
        }
        return -1;
    }

    private Node getAndMove(int key) {
        Node node = map.get(key);
        int count = node.getCount() + 1;
        node.setCount(count);
        move(node);
        return node;
    }

    private void move(Node node) {
        while (null != node.next && node.getCount() >= node.next.getCount()) {
            Node next = node.next;
            node.pre.next = next;
            node.pre = next;
            node.next = next.next;
            next.next = node;
        }
    }

    public void put(int key, int value) {
        // 处理第一个插入
        if (null == head) {
            head = new Node(null, null, 1, value);
        }

        if (map.containsKey(key)) {
            Node node = getAndMove(key);
            node.setValue(value);
        } else {
            Node node = new Node(head, null, 1, value);
            head = node;
            move(node);
            num ++;
            if (num > capacity) {
                head = head.next;
            }
        }
    }

    class Node {
        private Node next;
        private Node pre;
        private int count;
        private int value;

        public Node(Node next, Node pre, int count, int value) {
            this.next = next;
            this.pre = pre;
            this.count = count;
            this.value = value;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }
}

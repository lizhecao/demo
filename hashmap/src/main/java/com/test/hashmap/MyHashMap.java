package com.test.hashmap;

public class MyHashMap<K, V> implements MyHashMapInterface<K, V> {
    public class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node<K, V>[] array;

    /**
     * 总的键值对数
     */
    private int num = 0;

    /**
     * 数组的容量
     */
    private int len;

    /**
     * 负载因子
     */
    private float loadFactor;

    public MyHashMap(int len, float loadFactor) {
        init(len, loadFactor);
    }

    private void init(int len, float loadFactor) {
        this.len = len;
        this.loadFactor = loadFactor;
        // 泛型数组初始化
        this.array = (Node<K, V>[]) new Node[len];
    }

    /**
     * 默认创建长度为16的数组，因为16 为 2^n，考虑到hash()方法的效率
     */
    public MyHashMap() {
        init(16, 0.8f);
    }

    @Override
    public int length() {
        return num;
    }

    @Override
    public void insert(K k, V v) {
        int pos = hash(k);
        Node<K, V> curNode = array[pos];

        if (num >= len * loadFactor) {
            resize();
        }

        while (null != curNode) {
            curNode = curNode.next;
            if (curNode.key.equals(k)) {
                curNode.value = v;
                return;
            }
        }

        // 不存在的情况下插入到链表最后面
        curNode = new Node(k, v);
        num++;
    }

    @Override
    public V get(K k) {
        int pos = hash(k);
        Node<K, V> curNode = array[pos];
        while (null != curNode) {
            if (curNode.key.equals(k)) {
                return curNode.value;
            }
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public boolean contain(K k) {
        if (null == get(k)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void del(K k) {
        int pos = hash(k);
        Node<K, V> curNode = array[pos];
        if (null == curNode) {
            throw new RuntimeException("key not exist");
        }

        if (curNode.key.equals(k)) {
            array[pos] = curNode.next;
        } else {
            Node<K, V> lastNode = curNode;
            while ((curNode = curNode.next) != null) {
                if (curNode.key.equals(k)) {
                    lastNode.next = curNode.next;
                    return;
                }
            }
            throw new RuntimeException("key not exist");
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < array.length; i++) {
            Node<K, V> x = array[i];
            while (null != x) {
                System.out.println("key:" + x.key + "\tvalue:" + x.value);
                x = x.next;
            }
        }

        System.out.println("num: " + num);
        System.out.println("len: " + len);
    }


    private int hash(K key) {
        return (key.hashCode() ^ (key.hashCode() >>> 16)) & (len - 1);
    }

    /**
     * 当总的键值对数num 大于 数组总长度 乘以 负载因子的时候，数组需要扩容
     */
    private void resize() {
        len = len * 2;
        num = 0;
        Node<K, V>[] oldArr = array;
        array = (Node<K, V>[]) new Node[len];
        for (int i = 0; i < oldArr.length; i++) {
            Node<K, V> node = oldArr[i];
            while (null != node) {
                insert(node.key, node.value);
                node = node.next;
            }
        }
    }

//  public static void main(String[] args) {
//    MyHashMapInterface<Integer, String> map = new MyHashMap<>(16, 0.5f);
//    map.insert(1, "ryan");
//    map.insert(38, "jack");
//    map.insert(119, "rose");
//
//    map.print();
//
////    System.out.println(map.get(119));
////
////    map.del(849);
//
////    map.print();
//
////    map.insert(880, "ethan");
//
//    for (int i = 0; i < 100; i ++) {
//      map.insert(i+200, "hello");
//    }
//    map.print();
//  }
}

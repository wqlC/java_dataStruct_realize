package com.test.map;

/**
 * @author tailor
 * @create 2020/3/26 - 14:35
 * @mail wql2014302721@gmail.com
 */
public class LinkedListMap<K, V> implements Map<K, V>{

    private class Node{
        public K key;
        public V value;
        public  Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key){
            this(key, null, null);
        }
        public Node(){
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString()+" : "+value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node!=null){
            node.value = value;
        }else{
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if(node == null){
            return null ;
        }else{
            Node prev = dummyHead;
            while(prev.next != null){
                if(prev.next.key.equals(key)){
                    prev.next = prev.next.next;
                    size--;
                    break;
                }
            }
        }
        return node.value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node==null ? null : node.value;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals((key))){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException("key doesn't exist!");
        }else{
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}

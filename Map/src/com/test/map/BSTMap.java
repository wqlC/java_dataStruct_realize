package com.test.map;


import sun.swing.MenuItemLayoutHelper;

import javax.management.modelmbean.RequiredModelMBean;
import java.util.logging.Level;

/**
 * @author tailor
 * @create 2020/3/26 - 15:33
 * @mail wql2014302721@gmail.com
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }
    private Node add(Node node, K key, V value){
        if(node == null){
            node = new Node(key, value);
            size++;
        }else{
            if(key.compareTo(node.key)<0){
                add(node.left, key, value);
            }else if(key.compareTo(node.key)>0){
                add(node.right, key, value);
            }else if(key.compareTo(node.key) == 0){
                node.value = value;
            }
        }
        return node;
    }

    @Override
    public V remove(K key) {//TODO
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }
    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left, key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right = remove(node.right, key);
            return node;
        }else {
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }else{
                Node successor = minimun(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;
                node.left = null;
                node.right = null;
                return successor;
            }
        }
    }

    private Node minimun(Node node) {
        if(node.left == null){
            return node;
        }
        return minimun(node.left);
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }else{
            node.left = removeMin(node.left);
            return node;
        }
    }
    private Node removeMax(Node node) {
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }else{
            node.right = removeMax(node.right);
            return node;
        }
    }



    @Override
    public boolean contains(K key) {
        Node node = getNode(root , key);
        return node==null?false:true;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if(node == null){
            return null;
        }else{
            return node.value;
        }
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException("Key doesn't exist!");
        }else{
            node.value = newValue;
        }
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }else if(key.compareTo(node.key)<0){
            return getNode(node.left, key);
        }else if(key.compareTo(node.key)>0){
            return getNode(node.right, key);
        }else {
            return node;
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

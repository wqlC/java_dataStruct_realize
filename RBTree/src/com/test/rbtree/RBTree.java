package com.test.rbtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tailor
 * @create 2020/4/7 - 21:42
 * @mail wql2014302721@gmail.com
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            color = RED;
        }
    }
    private int size;
    private Node root;
    public RBTree(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(K key, V value){
        root = add(root, key, value);
        // 确保根节点为黑色
        root.color = BLACK;
    }
    private Node add(Node node, K key, V value){
        if(node == null){
            size++;
            return new Node(key, value);// 默认插入一个红色的节点
        }
        if(key.compareTo(node.key)<0){
            node.left = add(node.left, key, value);
        }else{
            node.right = add(node.right, key, value);
        }

        // 维护红黑树
        if(isRed(node.right) && ! isRed(node.left)){// 左旋转
            node = leftRotate(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){// 右旋转
            node = rightRotate(node);
        }
        if(isRed(node.left) && isRed(node.right)){// 颜色反转
            flipColors(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        return node.color == RED;
    }

    private Node leftRotate(Node node){
        Node rightNode = node.right;
        Node tempNode = rightNode.left;
        rightNode.left = node;
        node.right = tempNode;
        rightNode.color = node.color;
        node.color = RED;
        return rightNode;
    }
    private Node rightRotate(Node node){
        Node leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        leftNode.color = node.color;
        node.color = RED;
        return leftNode;
    }

    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 看二分搜索树中是否包含某一个元素
     * @param key 要查看的元素
     * @return  是否包含元素 key
     */
    public boolean contains(K key){
        return contains(root, key);
    }
    // 看 以node 为根节点的二叉搜索树中是否包含元素 e
    private boolean contains(Node node, K key){
        if(node == null){
            return false;
        }
        if(node.key == key){
            return true;
        }else if(key.compareTo(node.key)<0){
            return contains(node.left, key);
        }else{
            return contains(node.right, key);
        }
    }
    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node!=null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 二分搜索树的非递归前序遍历
     *  使用Stack<>这种数据结构
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.key);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的层次遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node!=null){
                System.out.println(node.key);
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    /**
     * 获取二叉搜索树的最小值
     * @return
     */
    public K minimum(){
        return minimum(root).key;
    }
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }else{
            return minimum(node.left);
        }
    }

    /**
     * 获取二叉搜索树的最大值
     * @return
     */
    public K maximum(){
        return maximum(root).key;
    }
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }else{
            return maximum(node.right);
        }
    }

    /**
     * 删除二叉搜索树的最小值节点
     * @return
     */
    public K removeMin(){
        K ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
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

    /**
     * 删除最大值节点
     * @return
     */
    public K removeMax(){
        K ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
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

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param key 待删除的节点的元素为e
     */
    public void remove(K key){
        root = remove(root, key);
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
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else{
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBstString(root, 0, sb);
        return sb.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder sb) {
        if(node == null){
            sb.append(generateDepthString(depth)+null+"\n");
            return;
        }else{
            sb.append(generateDepthString(depth)+node.key+"\n");
        }
        generateBstString(node.left, depth+1, sb);
        generateBstString(node.right, depth+1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<depth; i++){
            sb.append("--");
        }
        return sb.toString();
    }
}
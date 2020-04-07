package com.test.avltree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;

/**
 * @author tailor
 * @create 2020/4/7 - 14:39
 * @mail wql2014302721@gmail.com
 */
public class AVLTree<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left;
        public Node right;
        public int height;// 节点对应的高度
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
            height = 1;
        }
    }
    private Node root;
    private int size;
    public AVLTree(){
        root = null;
        size = 0;
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    public void add(E e){
        root = add(root, e);
    }

    private Node rightRotate(Node node){
        Node leftNode = node.left;
        Node temp = leftNode.right;
        // 右旋转过程
        leftNode.right = node;
        node.left = temp;
        // 更新height
        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
        leftNode.height = Math.max(getHeight(leftNode.left), getHeight(leftNode.right))+1;
        return leftNode;
    }
    private Node leftRotate(Node node){
        Node rightNode = node.right;
        Node temp = rightNode.left;
        rightNode.left = node;
        node.right = temp;
        // 更新height
        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
        rightNode.height = Math.max(getHeight(rightNode.left), getHeight(rightNode.right));
        return rightNode;
    }
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right, e);
        }else{
            node.e = e;
            return node;
        }
        // 更新height
        node.height = 1+Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
//        if(Math.abs(balanceFactor)>1){
//            System.out.println("unbalanced: " + balanceFactor);
//        }
        // 平衡维护
        // LL
        if(balanceFactor>1 && getBalanceFactor(node.left)>=0)
            return rightRotate(node);
        //RR
        if(balanceFactor<-1 && getBalanceFactor(node.right)<=0){
            return leftRotate(node);
        }
        // LR
        if(balanceFactor>1 && getBalanceFactor(node.left)<0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL
        if(balanceFactor<-1 && getBalanceFactor(node.right)>0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    // 判断当前二叉树是不是一个二分搜索树：
    public boolean isBST(){
        ArrayList<E> arrayList = new ArrayList<>();
        inOrder(root, arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i-1).compareTo(arrayList.get(i))>0){
                return false;
            }
        }
        return true;
    }
    // 判断该二叉树是否是一棵平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }
    private void inOrder(Node node, ArrayList<E> arrayList) {
        inOrder(node.left, arrayList);
        arrayList.add(node.e);
        inOrder(node.right, arrayList);
    }
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        Node retNode;
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left, e);
            retNode = node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right, e);
            retNode = node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode =  leftNode;
            }else{
                Node successor = minimum(node.right);
                successor.right = remove(node.right, e);
                successor.left = node.left;

                node.left = node.right = null;
                retNode = successor;
            }
        }

        if(retNode == null){
            return null;
        }
        // 更新height
        retNode.height = 1+Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        // 平衡维护
        // LL
        if(balanceFactor>1 && getBalanceFactor(retNode.left)>=0)
            return rightRotate(retNode);
        //RR
        if(balanceFactor<-1 && getBalanceFactor(retNode.right)<=0){
            return leftRotate(retNode);
        }
        // LR
        if(balanceFactor>1 && getBalanceFactor(retNode.left)<0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // RL
        if(balanceFactor<-1 && getBalanceFactor(retNode.right)>0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }
    public E minimum(){
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }else{
            return minimum(node.left);
        }
    }
}

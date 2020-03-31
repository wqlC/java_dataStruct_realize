package com.test.maxheap;
import com.sun.glass.ui.Size;
import com.sun.org.apache.bcel.internal.generic.SWAP;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.*;
/**
 * @author tailor
 * @create 2020/3/31 - 15:49
 * @mail wql2014302721@gmail.com
 */

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;
    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }
    public MaxHeap(){
        data = new Array<>();
    }
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length-1); i >=0; i--) {
            siftDown(i);
        }
    }

    // 返回堆中元素个数
    public int getSize(){
        return data.getSize();
    }
    // 返回一个布尔值，判断堆是否为空
    public boolean idEmpty(){
        return data.isEmpty();
    }
    // 返回二叉堆中，一个索引index对应的父亲节点的索引
    public int parent(int index){
        if(index==0){
            throw new IllegalArgumentException("Index-0 don't have parent.");
        }
        return (index-1)/2;
    }

    // 向堆中添加元素-Sift-Up
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }
    private void siftUp(int k){
        while(k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }
    // 取出堆中的最大的元素-Sift-Down
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }
    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }
        return data.get(0);
    }
    private void siftDown(int k){
        // 当k所处的节点已经是孩子节点了，说明不能下沉了
        while (leftChild(k)<data.getSize()){
            int max = leftChild(k);// max是左右孩子中较大的那个节点对应的索引
            if(max+1<data.getSize() &&
                    data.get(max+1).compareTo(data.get(max))>0){
                max = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(max))>=0){
                break;
            }
            data.swap(k, max);
            k = max;
        }
    }

    private int rightChild(int k) {
        if(k >= data.getSize()){
            throw new IllegalArgumentException("Index Illegal.");
        }
        return 2*k+2;
    }

    private int leftChild(int k) {
        if(k >= data.getSize()){
            throw new IllegalArgumentException("Index Illegal.");
        }
        return 2*k+1;
    }
    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}

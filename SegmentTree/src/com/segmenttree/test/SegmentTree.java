package com.segmenttree.test;
/**
 * @author tailor
 * @create 2020/3/31 - 18:45
 * @mail wql2014302721@gmail.com
 */
public class SegmentTree <E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4*arr.length];
        buildSegmentTree(0, 0, data.length-1, merger);
    }
    //在treeIndex位置创建表示区间[l,...,r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r, Merger<E> merger) {
        if(l==r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l+(r-l)/2;
        buildSegmentTree(leftTreeIndex, l, mid, merger);
        buildSegmentTree(rightTreeIndex, mid+1, r, merger);
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }
    // 查询操作
    public E query(int queryL, int queryR){
        return query(0, 0, data.length-1, queryL, queryR);
    }
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if(l==queryL && r==queryR){
            return tree[treeIndex];
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL>=mid+1){
            return query(rightTreeIndex, mid+1, r, queryL, queryR);
        }else if(queryR<=mid){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid,queryL, mid);
        E rightResult = query(rightTreeIndex, mid+1, r, mid+1,queryR);
        return merger.merger(leftResult, rightResult);
    }

    // 更新操作
    // 将index位置的值，更新为e
    public void set(int index, E e){
        if(index<0||index>=data.length){
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
        // 更新线段树中的值
        set(0, 0, data.length-1, index, e);
    }
    private void set(int treeIndex, int l, int r, int index, E e){
        if(l==r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index>=mid+1){
            set(rightTreeIndex, mid+1, r, index, e);
        }else if(index<=mid){
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize(){
        return data.length;
    }
    public E get(int index){
        if(index<0 || index>=data.length)
            throw new IllegalArgumentException("Index illegal");
        return data[index];
    }
    private int leftChild(int index){
        return 2*index+1;
    }
    private int rightChild(int index){
        return 2*index+2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0; i<tree.length; i++){
            if(tree[i] != null){
                sb.append(tree[i]);
            }else{
                sb.append("null");
            }
            if(i!=tree.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

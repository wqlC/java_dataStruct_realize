package com.unionfind.test;

/**基于数组的并查集
 * 每次合并都要把对应集合的所有元素对应的id都改变
 * @author tailor
 * @create 2020/4/3 - 17:48
 * @mail wql2014302721@gmail.com
 */
public class UnionFind1 implements UF {

    private int[] id; // 每一个元素对应所属集合的编号

    public UnionFind1(int size){
        id = new int[size];
        for (int i = 0; i < size; i++) {// 初始的时候每一个节点对应的id都不同
            id[i] = i;
        }
    }
    @Override
    public int getSize() {
        return id.length;
    }

    // 查找元素p所对应的集合编号
    private int find(int p){
        if(p<0 || p>=id.length){
            throw new IllegalAccessError("p is out of bound");
        }
        return id[p];
    }

    // 查看元素p和元素q是否属于同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void UnionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if(pID == qID){
            return;
        }else{
            for (int i = 0; i < id.length; i++) {
                if(id[i] == pID){
                    id[i] = qID;
                }
            }
        }
    }
}

package com.unionfind.test;
/**基于树的并查集，每次合并只要改变根节点的指向就行了
 * @author tailor
 * @create 2020/4/3 - 18:01
 * @mail wql2014302721@gmail.com
 */
public class UnionFind2 implements UF{
    private int[] parent;
    public UnionFind2(int size){
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    private int find(int p){
        if(p<0 || p>=parent.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        while (p!=parent[p]){
            p = parent[p];
        }
        return p;
    }
    @Override
    public void UnionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot){
            return;
        }else{
            parent[pRoot] = qRoot;
        }
    }
}
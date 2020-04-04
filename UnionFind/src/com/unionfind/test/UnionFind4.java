package com.unionfind.test;

/**基于树的并查集，针对rank的优化
 * rank[i] 表示根节点为i的树的高度
 * @author tailor
 * @create 2020/4/4 - 15:27
 * @mail wql2014302721@gmail.com
 */
public class UnionFind4 implements UF{
    private int[] parent;
    private int[] rank;
    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

    private int find(int p) {
        if(p<0 || p>=parent.length)
            throw new IllegalArgumentException("p is out of bound");
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void UnionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot] = qRoot;

        }else if(rank[pRoot]>rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{
            parent[qRoot] = pRoot;
            rank[pRoot]+=1;
        }

    }
}

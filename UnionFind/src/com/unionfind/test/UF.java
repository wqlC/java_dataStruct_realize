package com.unionfind.test;

/**
 * @author tailor
 * @create 2020/4/2 - 11:48
 * @mail wql2014302721@gmail.com
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void UnionElements(int p, int q);
}

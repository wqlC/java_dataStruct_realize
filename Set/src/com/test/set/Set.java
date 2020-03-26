package com.test.set;

/**
 * @author tailor
 * @create 2020/3/26 - 10:30
 * @mail wql2014302721@gmail.com
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}

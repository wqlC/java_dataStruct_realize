package com.test.set;

import java.util.LinkedList;

/**
 * @author tailor
 * @create 2020/3/26 - 10:54
 * @mail wql2014302721@gmail.com
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    @Override
    public void add(E e) {
        if(!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}

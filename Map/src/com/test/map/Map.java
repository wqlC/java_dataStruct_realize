package com.test.map;

/**
 * @author tailor
 * @create 2020/3/26 - 14:32
 * @mail wql2014302721@gmail.com
 */
public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newVlaue);
    int getSize();
    boolean isEmpty();
}

package com.test.hashtable;
import javafx.scene.control.TableView;
import jdk.nashorn.internal.ir.OptimisticLexicalContext;

import java.util.*;

/**
 * @author tailor
 * @create 2020/4/10 - 9:44
 * @mail wql2014302721@gmail.com
 */
public class HashTable<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;
    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }
    public HashTable(){
        this(initCapacity);
    }
    private int hash(K key){
        return (key.hashCode()&0x7fffffff)%M;
    }
    public int getSize(){
        return size;
    }
    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            map.put(key, value);
        }else{
            map.put(key, value);
            size++;
            if(size>= upperTol*M){
                resize(2*M);
            }
        }
    }
    public V remove(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if(map.containsKey(key)){
            ret = map.remove(key);
            size--;
            if(size<lowerTol*M && M/2>initCapacity){
                resize(M/2);
            }
        }
        return ret;
    }
    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            map.put(key, value);
        }else{
            throw new IllegalArgumentException(key + "doesn't exist!");
        }
    }
    public boolean contains(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        return map.containsKey(key);
    }
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashtable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashtable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashtable[i];
            for (K key: map.keySet()){
                newHashtable[hash(key)].put(key, map.get(key));
            }
        }
        this.hashtable = newHashtable;
    }
}

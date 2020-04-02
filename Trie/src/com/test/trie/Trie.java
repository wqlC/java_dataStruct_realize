package com.test.trie;

import sun.nio.cs.FastCharsetProvider;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author tailor
 * @create 2020/4/1 - 18:20
 * @mail wql2014302721@gmail.com
 */
public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(){
            this(false);
        }
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }
    private Node root;
    private int size;
    public Trie(){
        size = 0;
        root = new Node();
    }
    // 获得Trie中存储的单词的数量
    public int getSize(){
        return size;
    }
    // 向Trie字典树中添加元素
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node(false));
            }else{
                cur = cur.next.get(c);
            }
        }
        if(! cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
    // 判断单词word是否在trie字典树中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    // 查询在trie中是否有单词以prefix为前缀
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}

package com.unionfind.test;

import org.omg.Messaging.SyncScopeHelper;

import java.util.Random;

/**
 * @author tailor
 * @create 2020/4/3 - 18:33
 * @mail wql2014302721@gmail.com
 */
public class Main {
    private static double test(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();
        long start = System.nanoTime();
        for(int i=0; i<m; i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.UnionElements(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }
        long end = System.nanoTime();
        return (end-start)/1.0E9;
    }

    public static void main(String[] args) {
        int size = 100000000;
        int m = 10000000;
//        UF uf1 = new UnionFind1(size);
//        System.out.println("UnioFind1: " + test(uf1, m) + "'s");
//        UF uf2 = new UnionFind2(size);
//        System.out.println("UnioFind2: " + test(uf2, m) + "'s");
        UF uf3 = new UnionFind3(size);
        System.out.println("UnioFind3: " + test(uf3, m) + "'s");
        UF uf4 = new UnionFind4(size);
        System.out.println("UnioFind4: " + test(uf4, m) + "'s");
        UF uf5 = new UnionFind5(size);
        System.out.println("UnioFind5: " + test(uf5, m) + "'s");
        UF uf6 = new UnionFind5(size);
        System.out.println("UnioFind6: " + test(uf6, m) + "'s");
    }
}

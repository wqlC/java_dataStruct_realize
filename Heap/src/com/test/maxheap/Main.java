package com.test.maxheap;

import java.util.List;
import java.util.Random;

/**
 * @author tailor
 * @create 2020/3/31 - 17:13
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        int count = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] res = new int[count];
        for(int i=0; i<maxHeap.getSize(); i++){
            res[i] = maxHeap.extractMax();
            System.out.println(res[i]);
        }
        for(int i=1; i<count; i++){
            if(res[i-1]<res[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Completed!");
    }
}

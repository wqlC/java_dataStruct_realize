package com.segmenttree.test;

/**
 * @author tailor
 * @create 2020/4/1 - 11:17
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merger(Integer a, Integer b) {
                return a+b;
            }
        });
//        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0, 2));
    }
}

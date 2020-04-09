package com.leetcode.test;

import java.awt.font.NumericShaper;

/**
 * @author tailor
 * @create 2020/4/8 - 21:57
 * @mail wql2014302721@gmail.com
 */
class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[i].length-1; j >= 0; j--) {
                if(target==matrix[i][j])
                    return true;
                else if(target>matrix[i][j])// 行增
                    break;
                else if(target<matrix[i][j])// 列减少
                    continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        System.out.println(new FindNumberIn2DArray().findNumberIn2DArray(nums, 19));
    }
}
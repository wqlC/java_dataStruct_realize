package com.leetcode.test;

/**
 * @author tailor
 * @create 2020/4/8 - 23:11
 * @mail wql2014302721@gmail.com
 */
public class BuildTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        return root;
    }
}

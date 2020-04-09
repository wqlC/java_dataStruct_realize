package com.leetcode.test;

import sun.awt.image.ImageWatched;

import java.io.PrintStream;
import java.util.*;

/**
 * @author tailor
 * @create 2020/4/8 - 23:20
 * @mail wql2014302721@gmail.com
 */
public class LevelOrder {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return new int[]{};
        }
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);
            if(node.left !=null){
                queue.add(node.left);
            }
            if(node.right !=null){
                queue.add(node.right);
            }
        }
        int size = list.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        Queue<TreeNode> mainQueue = new LinkedList<>();


        if(root == null){
            return ret;
        }
        mainQueue.add(root);
        while (! mainQueue.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (! mainQueue.isEmpty()){
                TreeNode temp = mainQueue.remove();
                tempList.add(temp.val);
                System.out.println(temp.val);
                if(temp.left!=null){
                    tempQueue.add(temp.left);
                }
                if(temp.right !=null){
                    tempQueue.add(temp.right);
                }
            }
            System.out.println(tempList.size());
            ret.add(tempList);
            mainQueue = tempQueue;
        }
        return ret;
    }
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Stack<TreeNode> mainStack = new Stack<>();
        if(root == null){
            return ret;
        }
        mainStack.push(root);
        int count = 0;
        while (! mainStack.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            Stack<TreeNode> tempStack = new Stack<>();
            while (! mainStack.isEmpty()){
                TreeNode temp = mainStack.pop();
                tempList.add(temp.val);
                if(count%2 == 0){
                    if(temp.left!=null){
                        tempStack.add(temp.left);
                    }
                    if(temp.right !=null){
                        tempStack.add(temp.right);
                    }
                }else{
                    if(temp.right !=null){
                        tempStack.add(temp.right);
                    }
                    if(temp.left!=null){
                        tempStack.add(temp.left);
                    }
                }

            }
            count++;
            ret.add(tempList);
            mainStack = tempStack;
        }
        return ret;
    }
}

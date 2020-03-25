package test.tailor.bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author tailor
 * @create 2020/3/25 - 15:42
 * @mail wql2014302721@gmail.com
 */
public class Main {
    public static void main(String[] args) {
//        BST<Integer> bst = new BST<>();
//        int[] nums = {5, 3, 6, 2, 4, 8};
//        for(int num: nums){
//            bst.add(num);
//        }
//
//        // 层次遍历
//        bst.levelOrder();
//        System.out.println("__________");
//        // 前序遍历
//        bst.preOrder();
//        System.out.println("------");
//        // 非递归前序遍历
//        bst.preOrderNR();
//        // 中序遍历
//        System.out.println("----------");
//        bst.inOrder();
//        // 后续遍历
//        System.out.println("----------");
//        bst.postOrder();
//
//        System.out.println("_____");
//        System.out.println(bst);

        BST<Integer> bst = new BST<>();
        int n = 1000;
        Random random = new Random();
        for(int i=0; i<n; i++){
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        while(! bst.isEmpty()){
            arrayList.add(bst.removeMin());
        }
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        for(int i=1; i<arrayList.size(); i++){
            if(arrayList.get(i-1)>arrayList.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMin test completed");

        System.out.println("-------");
        arrayList.clear();
        for(int i=0; i<n; i++){
            bst.add(random.nextInt(10000));
        }

        while(! bst.isEmpty()){
            arrayList.add(bst.removeMax());
        }
        System.out.println(arrayList.size());
        System.out.println(arrayList);
        for(int i=1; i<arrayList.size(); i++){
            if(arrayList.get(i-1)<arrayList.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("removeMax test completed");
    }
}

package test.tailor.bst;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tailor
 * @create 2020/3/24 - 18:03
 * @mail wql2014302721@gmail.com
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left;
        public Node right;
        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private int size;
    private Node root;
    public BST(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(E e){
        root = add(root, e);
    }
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left, e);
        }else{
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 看二分搜索树中是否包含某一个元素
     * @param e 要查看的元素
     * @return  是否包含元素 e
     */
    public boolean contains(E e){
        return contains(root, e);
    }
    // 看 以node 为根节点的二叉搜索树中是否包含元素 e
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(node.e == e){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }
    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node!=null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 二分搜索树的非递归前序遍历
     *  使用Stack<>这种数据结构
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的层次遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node!=null){
                System.out.println(node.e);
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.e);
        }
    }

    /**
     * 获取二叉搜索树的最小值
     * @return
     */
    public E minimum(){
        return minimum(root).e;
    }
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }else{
            return minimum(node.left);
        }
    }

    /**
     * 获取二叉搜索树的最大值
     * @return
     */
    public E maximum(){
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }else{
            return maximum(node.right);
        }
    }

    /**
     * 删除二叉搜索树的最小值节点
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }else{
            node.left = removeMin(node.left);
            return node;
        }
    }

    /**
     * 删除最大值节点
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }else{
            node.right = removeMax(node.right);
            return node;
        }
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e 待删除的节点的元素为e
     */
    public void remove(E e){
        root = remove(root, e);
    }
    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right, e);
            return node;
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }else if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }else{
                Node successor = minimum(node.right);
                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;
                return successor;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBstString(root, 0, sb);
        return sb.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder sb) {
        if(node == null){
            sb.append(generateDepthString(depth)+null+"\n");
            return;
        }else{
            sb.append(generateDepthString(depth)+node.e+"\n");
        }
        generateBstString(node.left, depth+1, sb);
        generateBstString(node.right, depth+1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<depth; i++){
            sb.append("--");
        }
        return sb.toString();
    }

}

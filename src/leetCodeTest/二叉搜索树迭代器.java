package leetCodeTest;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉搜索树迭代器 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(20);
        二叉搜索树迭代器 er = new 二叉搜索树迭代器(treeNode);
    }

    private Deque<TreeNode> Stack;

    public 二叉搜索树迭代器(TreeNode root) {
        Stack = new LinkedList<>();
        findAll(root);
        System.out.println(Stack);
    }

    public void findAll(TreeNode root){
        while (root != null){
            Stack.offerFirst(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode treeNode = Stack.pollFirst();
        if (treeNode.right != null){
            findAll(treeNode.right);
        }
        return treeNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !Stack.isEmpty();
    }
}

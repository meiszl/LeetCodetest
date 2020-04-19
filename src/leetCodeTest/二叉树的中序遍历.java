package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(treeNode);
        System.out.println(list);
    }

    /**
     * 递归算法
     * @param root
     * @return
     */
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList();
//        search(root,list);
//        return list;
//    }
//    public static void search(TreeNode treeNode,List<Integer> res){
//        if (treeNode != null){
//            if (treeNode.left != null){
//                search(treeNode.left,res);
//            }
//            res.add(treeNode.val);
//            if (treeNode.right != null){
//                search(treeNode.right,res);
//            }
//        }
//    }

    /**
     * 使用栈消除递归。
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}

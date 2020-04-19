package leetCodeTest;

import util.TreeNode;

import java.util.*;

public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(treeNode);
        System.out.println("lists = " + lists);
    }

    /**
     * 传统的递归算法
     * @param root
     * @return
     */
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> lists = new ArrayList();
//        search(root,lists,0);
//        System.out.println("lists = " + lists);
//        return lists;
//    }
//    public static void search(TreeNode treeNode,List<List<Integer>> res,int num){
//        if (treeNode != null){
//            if (num <= res.size()-1){
//                res.get(num).add(treeNode.val);
//            }else {
//                List<Integer> list = new ArrayList();
//                list.add(treeNode.val);
//                res.add(list);
//            }
//            if (treeNode.left != null)
//                search(treeNode.left, res, num + 1);
//            if (treeNode.right != null)
//                search(treeNode.right, res,num + 1);
//        }
//    }

    /**
     * 用队列代替递归
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList();
        if (root == null) return lists;
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        int i,level = 0;
        while (!deque.isEmpty()){
            lists.add(new ArrayList());
            int lev_leng = deque.size();
            for (i=0;i<lev_leng;i++){
                TreeNode poll = deque.remove();
                lists.get(level).add(poll.val);
                if (poll.left != null) deque.add(poll.left);
                if (poll.right != null) deque.add(poll.right);
            }
            level++;
        }
        return lists;
    }
}

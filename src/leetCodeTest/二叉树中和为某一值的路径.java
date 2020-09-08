package leetCodeTest;

import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);
        treeNode.left.left.left.left = new TreeNode(8);
        treeNode.left.left.right.left = new TreeNode(7);
        treeNode.left.left.right.right = new TreeNode(10);
        treeNode.right.right.left.left = new TreeNode(6);
        List<List<Integer>> lists = pathSum(treeNode, 35);
        System.out.println("lists = " + lists);
    }
    private static LinkedList<List<Integer>> lists;
    private static LinkedList<Integer> res;
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new LinkedList<>();
        res = new LinkedList<>();
        dfs(root,sum);
        return lists;
    }
    public static void dfs(TreeNode root,int k){
        if (root == null){
            return;
        }
        res.add(root.val);
        k -= root.val;
        if (k==0&&root.left == null&& root.right == null)
            lists.add(new LinkedList<>(res));
        dfs(root.left, k);
        dfs(root.right, k);
        res.removeLast();
    }
}
class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode(int x){
        val = x;
    }
    public void printTree(TreeNode treeNode){
        System.out.println(treeNode.val);
        if (treeNode.left != null){
            printTree(treeNode.left);
        }
        if (treeNode.right != null){
            printTree(treeNode.right);
        }
    }
}

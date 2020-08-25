package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(5);
        List<String> list = binaryTreePaths(treeNode);
        System.out.println("list = " + list);
    }
    private static List<String> res;
    public static List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root,"");
        return res;
    }
    public static void dfs(TreeNode treeNode,String re){
        re += treeNode.val + "->";
        if (treeNode.left == null && treeNode.right == null) {
            res.add(re.substring(0,re.length()-2));
            return;
        }
        if (treeNode.left != null)
            dfs(treeNode.left,re);
        if (treeNode.right != null)
            dfs(treeNode.right, re);
    }
}

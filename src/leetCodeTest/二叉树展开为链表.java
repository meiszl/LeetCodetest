package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(5);
        tr.left.left = new TreeNode(3);
        tr.left.right = new TreeNode(4);
        tr.right.right = new TreeNode(6);
        flatten(tr);
        tr.printTree(tr);
    }
    public  static void flatten(TreeNode root) {
        if (root == null)
            return;
        //将根节点的左子树变成链表
        flatten(root.left);
        //将根节点的右子树变成链表
        flatten(root.right);
        TreeNode temp = root.right;
        //把树的右边换成左边的链表
        root.right = root.left;
        //记得要将左边置空
        root.left = null;
        //找到树的最右边的节点
        while(root.right != null) root = root.right;
        //把右边的链表接到刚才树的最右边的节点
        root.right = temp;
    }
}

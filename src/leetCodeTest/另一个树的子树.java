package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 另一个树的子树 {
    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.right = new TreeNode(2);
        s.left.left = new TreeNode(1);
        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);
        boolean subtree = isSubtree(s, t);
        System.out.println("subtree = " + subtree);
    }

    /**
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return TreeFind(s, t);
    }
    public static boolean TreeFind(TreeNode treeNode,TreeNode t){
        if (treeNode == null) return false;
        return (check(treeNode, t)||TreeFind(treeNode.left, t)||TreeFind(treeNode.right, t));
    }
    public static boolean check(TreeNode t,TreeNode s){
        if (t == null&& s == null) return true;
        if ((t==null && s != null)||(s == null&&t != null)|| (s.val != t.val)) return false;
        return (check(t.left,s.left) && check(t.right,s.right));
    }
}

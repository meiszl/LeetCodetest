package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class 从先序遍历还原二叉树 {
    public static void main(String[] args) {
        String s = "1-401--349---90--88";
        TreeNode treeNode = recoverFromPreorder(s);
        treeNode.printTree(treeNode);
    }
    private static String s;
    private static int idx = 0,dep = 0,n;
    public static TreeNode recoverFromPreorder(String S) {
        s = S;
        n = S.length();
        return dfs(0);
    }

    private static TreeNode dfs(int td) {
        while (idx < n&&s.charAt(idx) == '-'){
            dep++;
            idx++;
        }
        if (td != dep) return null;
        int val = 0;
        while (idx < n&&s.charAt(idx) != '-')
            val = val*10+s.charAt(idx++) - '0';
        TreeNode p = new TreeNode(val);
        dep = 0;
        p.left = dfs(td+1);
        p.right = dfs(td + 1);
        return p;
    }
}

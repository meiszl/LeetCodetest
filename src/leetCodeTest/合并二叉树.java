package leetCodeTest;

import util.TreeNode;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        dfs(t1, t2);
        return t1;
    }
    public void dfs(TreeNode t1,TreeNode t2){
        if (t1 == null||t2 == null)
            return;
        boolean leflag = true;
        boolean riflag = true;
        if (t1.left == null && t2.left != null){
            t1.left = t2.left;
            leflag = false;
        }
        if (t1.right == null && t2.right != null){
            t1.right = t2.right;
            riflag = false;
        }
        t1.val = t1.val + t2.val;
        if (leflag && t1.left != null && t2.left != null){
            dfs(t1.left,t2.left);
        }
        if (riflag && t1.right != null && t2.right != null){
            dfs(t1.right,t2.right);
        }
    }
}

package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 对称二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);
        boolean symmetric = isSymmetric(treeNode);
        System.out.println("symmetric = " + symmetric);
    }
//    public static boolean isSymmetric(TreeNode root) {
//        if (root!=null){
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root.left);
//            queue.offer(root.right);
//            while (!queue.isEmpty()){
//                int size = queue.size();
//                List<TreeNode> list  = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//                    TreeNode poll = queue.poll();
//                    list.add(poll);
//                    if (poll != null){
//                        queue.offer(poll.left);
//                        queue.offer(poll.right);
//                    }
//                }
//                if (list.size() %2 != 0)
//                    return false;
//                for (int i = 0; i < list.size() / 2; i++) {
//                    TreeNode treeNode = list.get(i);
//                    TreeNode treeNode1 = list.get(list.size() - 1 - i);
//                    if (treeNode != null&& treeNode1 != null){
//                        if (treeNode.val != treeNode1.val)
//                            return false;
//                    }else {
//                        if (treeNode != treeNode1)
//                            return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    /**
     * 递归算法
     * @param root
     * @return
     */
//    public static boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//    public static boolean isMirror(TreeNode t1,TreeNode t2){
//        if (t1 == null&& t2 == null) return true;
//        if (t1 == null || t2 == null) return false;
//        return (t1.val == t2.val)&&isMirror(t1.right, t2.left)&&isMirror(t1.left, t2.right);
//    }
    /**
     * 队列迭代
     */
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

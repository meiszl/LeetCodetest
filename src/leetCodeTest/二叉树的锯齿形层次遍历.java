package leetCodeTest;

import util.TreeNode;

import java.util.*;

public class 二叉树的锯齿形层次遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        List<List<Integer>> lists = zigzagLevelOrder(treeNode);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("Arrays.toString(lists.get(i)) = " + lists.get(i));
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode;
                List<Integer> list = new ArrayList();
                int size = queue.size();
                for (int i=0;i<size;i++){
                    TreeNode poll = queue.poll();
                    list.add(poll.val);
                    if (poll.right!= null){
                        queue.offer(poll.right);
                    }
                    if (poll.left != null){
                        queue.offer(poll.left);
                    }
                }
                lists.add(list);
            }
            for (int i = 0; i < lists.size(); i++) {
                if (i %2 == 0)
                    Collections.reverse(lists.get(i));
            }
        }
        return lists;
    }
}

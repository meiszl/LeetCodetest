package leetCodeTest;

import util.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 二叉搜索树中的第k小元素 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);
        int i = kthSmallest(treeNode, 1);
        System.out.println("i = " + i);
    }
    /**
     * 大顶堆方法
     * @param k
     * @return
     */
//    public static int kthSmallest(TreeNode root, int k) {
//        if (root == null || k <= 0) return 0;
//        PriorityQueue<Integer> bfs = bfs(root, k);
//        System.out.println("bfs = " + bfs);
//        return bfs.poll();
//    }
//    public static PriorityQueue<Integer> bfs(TreeNode treeNode,int k){
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        if (treeNode != null){
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(treeNode);
//            while (!queue.isEmpty()){
//                TreeNode poll = queue.poll();
//                priorityQueue.add(poll.val);
//                if (priorityQueue.size() > k)
//                    priorityQueue.poll();
//                if (poll.left != null){
//                    queue.offer(poll.left);
//                }
//                if (poll.right != null){
//                    queue.offer(poll.right);
//                }
//            }
//        }
//        return priorityQueue;
//    }

    /**
     * 深度优先搜索+剪枝提升效率。
     * @param root
     * @param k
     * @return
     */
    private static  int n = 0;
    private static int res;
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return 0;
        dfs(root, k);
        return res;
    }
    public static void dfs(TreeNode treeNode,int k){
        if (treeNode.left != null){
            dfs(treeNode.left,k);
        }
        n++;
        if (n == k){
            res = treeNode.val;
        }else if (n > k){
            return;
        }
        if (treeNode.right != null){
            dfs(treeNode.right, k);
        }
    }
}

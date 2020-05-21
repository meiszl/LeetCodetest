package OfferTest;

import util.TreeNode;

import java.util.*;

public class SearchTreeNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
//        List<Integer> list = searchChangeZTreeNode(treeNode);
//        System.out.println("list = " + list);
        Integer treeDepth = findTreeDepthByStack(treeNode);
        Integer treeDepthByQueue = findTreeDepthByQueue(treeNode);
        System.out.println("treeDepth = " + treeDepth);
    }

    /**
     * 二叉树的层次遍历
     * @param treeNode
     * @return
     */
//    public static List<Integer> searchTreeNode(TreeNode treeNode){
//        List<Integer> list = new ArrayList();
//        if (treeNode != null){
//            Queue<TreeNode> queue = new ArrayDeque();
//            if (treeNode != null)
//                queue.offer(treeNode);
//            while (!queue.isEmpty()){
//                TreeNode poll = queue.poll();
//                list.add(poll.val);
//                if (poll.left != null){
//                    queue.offer(poll.left);
//                }
//                if (poll.right!= null){
//                    queue.offer(poll.right);
//                }
//            }
//        }
//        return list;
//    }

    /**
     * 二叉树的交叉遍历
     * 输出1237654
     * @param treeNode
     * @return
     */
    public static List<Integer> searchZTreeNode(TreeNode treeNode){
        List<Integer> list = new ArrayList();
        if (treeNode != null){
            Map<TreeNode,Integer> map = new HashMap();
            Queue<TreeNode> queue = new LinkedList();
            Stack<TreeNode> stack = new Stack();
            queue.offer(treeNode);
            map.put(treeNode,0);
            TreeNode temp;
            while (!queue.isEmpty() || !stack.isEmpty()){
                if (queue.isEmpty()) {
                    temp = stack.pop();
                }else {
                    temp = queue.poll();
                }
                list.add(temp.val);
                int i = map.get(temp) + 1;
                if (temp.left != null){
                    if (i%2 != 0){
                        queue.offer(temp.left);
                    }else {
                        stack.push(temp.left);
                    }
                    map.put(temp.left,i);
                }
                if (temp.right != null){
                    if (i%2 != 0){
                        queue.offer(temp.right);
                    }else {
                        stack.push(temp.right);
                    }
                    map.put(temp.right,i);
                }
            }
        }
        return list;
    }

    /**
     * 二叉树的Z字形遍历，使用栈数据结构。
     * @param treeNode
     * @return
     */
//    public static List<Integer> searchChangeZTreeNode(TreeNode treeNode){
//        List<Integer> list = new ArrayList();
//        if (treeNode != null){
//            Stack<TreeNode> stack = new Stack();
//            stack.push(treeNode);
//            while (!stack.isEmpty()){
//                TreeNode poll = stack.pop();
//                list.add(poll.val);
//                if (poll.left != null){
//                    stack.push(poll.left);
//                }
//                if (poll.right != null){
//                    stack.push(poll.right);
//                }
//            }
//        }
//        return list;
//    }

    /**
     * 二叉树的深度，递归实现
     * @param treeNode
     * @return
     */
//    public static Integer findTreeDepth(TreeNode treeNode){
//        if (treeNode == null)
//            return 0;
//        int left = 0;
//        int right = 0;
//        if (treeNode.left != null){
//            left = findTreeDepth(treeNode.left);
//        }
//        if (treeNode.right != null){
//            right = findTreeDepth(treeNode.right);
//        }
//        return left >= right ? left + 1:right + 1;
//    }

    /**
     * 二叉树的深度，栈实现
     * @param treeNode
     * @return
     */
    public static Integer findTreeDepthByStack(TreeNode treeNode){
        int height = 0;
        if (treeNode != null){
            Stack<TreeNode> stack = new Stack();
            stack.push(treeNode);
            int i;
            while (!stack.isEmpty()){
                int size = stack.size();
                for (i=0;i<size;i++){
                    TreeNode pop = stack.pop();
                    if (pop.left!= null){
                        stack.push(pop.left);
                    }
                    if (pop.right != null){
                        stack.push(pop.right);
                    }
                }
                System.out.println("stack = " + stack);
                if (!stack.isEmpty())
                    height++;
            }
        }
        return height;
    }
    /**
     * 二叉树的深度，队列实现
     * @param treeNode
     * @return
     */
    public static Integer findTreeDepthByQueue(TreeNode treeNode){
        int height = 0;
        if(treeNode != null){
            Queue<TreeNode> queue = new LinkedList();
            queue.offer(treeNode);
            int i;
            while (!queue.isEmpty()){
                int size = queue.size();
                for (i=0;i<size;i++){
                    TreeNode poll = queue.poll();
                    if (poll.left != null){
                        queue.offer(poll.left);
                    }
                    if (poll.right != null){
                        queue.offer(poll.right);
                    }
                }
//                if (!queue.isEmpty())
                System.out.println("queue = " + queue);
                    height++;
            }
        }
        return height;
    }
     /*
      * 层序遍历（广度优先遍历）
      * */
//      public static void LayerOrder(TreeNode root) {
//         Queue<TreeNode> queue = new ArrayDeque<>();
//         if (root != null) queue.offer(root);
//         while (!queue.isEmpty()) {
//             TreeNode node = queue.poll();
//             System.out.print(node.val);
//             if (node.left != null) queue.offer(node.left);
//             if (node.right != null) queue.offer(node.right);
//         }
//      }
}

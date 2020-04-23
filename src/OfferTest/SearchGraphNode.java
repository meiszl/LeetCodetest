package OfferTest;

import util.GraphNode;

import java.util.*;

public class SearchGraphNode {
    public static void main(String[] args) {
        GraphNode<Integer> graphNode = new GraphNode();
        graphNode.data = 1;
        GraphNode<Integer> graphNode2 = new GraphNode();
        graphNode2.data = 2;
        GraphNode<Integer> graphNode3 = new GraphNode();
        graphNode3.data = 3;
        GraphNode<Integer> graphNode4 = new GraphNode();
        graphNode4.data = 4;
        GraphNode<Integer> graphNode5 = new GraphNode();
        graphNode5.data = 5;
        GraphNode<Integer> graphNode6 = new GraphNode();
        graphNode6.data = 6;
        List<GraphNode<Integer>> list = new ArrayList();
        list.add(graphNode4);
        list.add(graphNode3);
        list.add(graphNode2);
        list.add(graphNode6);
        graphNode.neighborList = list;
        List<GraphNode<Integer>> list1 = new ArrayList();
        list1.add(graphNode);
        list1.add(graphNode3);
        list1.add(graphNode5);
        list1.add(graphNode6);
        graphNode2.neighborList = list1;
        List<GraphNode<Integer>> list2 = new ArrayList();
        list2.add(graphNode);
        list2.add(graphNode2);
        list2.add(graphNode4);
        list2.add(graphNode5);
        graphNode3.neighborList = list2;
        List<GraphNode<Integer>> list3 = new ArrayList();
        list3.add(graphNode);
        list3.add(graphNode3);
        graphNode4.neighborList = list3;
        List<GraphNode<Integer>> list4 = new ArrayList();
        list4.add(graphNode2);
        list4.add(graphNode3);
        graphNode5.neighborList = list4;
        List<GraphNode<Integer>> list5 = new ArrayList();
        list5.add(graphNode);
        list5.add(graphNode2);
        graphNode6.neighborList = list5;
        List<Integer> list6 = bfs(graphNode);
        System.out.println("list6 = " + list6);
        List<Integer> list7 = dfs(graphNode);
        System.out.println("list7 = " + list7);
        Integer integer = CountGraphDepth(graphNode);
        System.out.println("integer = " + integer);
        int[][] ints = matrixInGraph(graphNode);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    /**
     * 图的广度优先遍历
     * @param graphNode
     * @return
     */
    public static List<Integer> bfs(GraphNode graphNode){
        List<Integer> list = new ArrayList();
        HashSet<GraphNode> hashSet = new HashSet();
        if (graphNode != null){
            Queue<GraphNode<Integer>> queue = new LinkedList();
            queue.offer(graphNode);
            while (!queue.isEmpty()){
                GraphNode<Integer> poll = queue.poll();
                List<GraphNode<Integer>> neighborList = poll.neighborList;
                if (!hashSet.contains(poll)){
                    list.add(poll.data);
                    hashSet.add(poll);
                }
                for (GraphNode<Integer> graphNode1 : neighborList) {
                    if (!hashSet.contains(graphNode1))
                        queue.offer(graphNode1);
                }
            }
        }
        return list;
    }
    private static List<Integer> list = new ArrayList();
    private static HashSet<GraphNode<Integer>> hashSet = new HashSet();

    /**
     * 图的深度优先遍历
     * @param graphNode
     * @return
     */
    public static List<Integer> dfs(GraphNode<Integer> graphNode){
        List<GraphNode<Integer>> neighborList = graphNode.neighborList;
        list.add(graphNode.data);
        hashSet.add(graphNode);
        for (GraphNode<Integer> graph: neighborList){
            if (!hashSet.contains(graph)){
                dfs(graph);
            }
        }
        return list;
    }

    /**
     * 从起点开始计算图的深度
     * @param graphNode
     * @return
     */
    public static Integer CountGraphDepth(GraphNode<Integer> graphNode){
        int height = 0;
        if (graphNode != null){
            Queue<GraphNode<Integer>> queue = new LinkedList();
            HashSet<GraphNode> hashSet = new HashSet();
            queue.offer(graphNode);
            int i;
            while (!queue.isEmpty()){
                for (i=0;i<queue.size();i++){
                    GraphNode<Integer> poll = queue.poll();
                    hashSet.add(poll);
                    List<GraphNode<Integer>> neighborList = poll.neighborList;
                    for (GraphNode<Integer> integerGraphNode : neighborList) {
                        if (!hashSet.contains(integerGraphNode)){
                            queue.offer(integerGraphNode);
                        }
                    }
                }
                if (!queue.isEmpty())
                    height++;
            }
        }
        return height;
    }

    /**
     * 输出图的邻接矩阵
     * @param graphNode
     * @return
     */
    public static int[][] matrixInGraph(GraphNode graphNode){
        Map<GraphNode,Integer> counmap = new HashMap();
        int[][] matrix = new int[0][0];
        if (graphNode != null){
            Queue<GraphNode> queue = new LinkedList();
            queue.offer(graphNode);
            int coun = 0;
            while (!queue.isEmpty()){
                GraphNode poll = queue.poll();
                if (!counmap.containsKey(poll)){
                    counmap.put(poll,coun++);
                }
                List<GraphNode> neighborList = poll.neighborList;
                for (int i = 0; i < neighborList.size(); i++) {
                    GraphNode o = neighborList.get(i);
                    if (!counmap.containsKey(o)){
                        queue.offer(o);
                    }
                }
            }
            int size = counmap.size();
            matrix = new int[size][size];
            for (Map.Entry<GraphNode, Integer> graphNodeIntegerEntry : counmap.entrySet()) {
                GraphNode key = graphNodeIntegerEntry.getKey();
                Integer value = graphNodeIntegerEntry.getValue();
                System.out.print(key.data + "=" + value + " ");
                List<GraphNode> neighborList = key.neighborList;
                for (GraphNode graph: neighborList){
                    Integer integer = counmap.get(graph);
                    matrix[value][integer] = 1;
                }
            }
            System.out.println();
        }
        return matrix;
    }
}

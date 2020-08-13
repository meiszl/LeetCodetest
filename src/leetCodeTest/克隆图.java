package leetCodeTest;

import java.util.*;

public class 克隆图 {
// Definition for a Node.
static class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

    /**
     * 广度优先搜索
     * @param node
     * @return
     */

    public static Node cloneGraph(Node node) {
        if(node != null){
            Deque<Node> deque = new LinkedList();
            deque.offerFirst(node);
            HashMap<Node,Node> hashset = new HashMap();
            hashset.put(node,new Node(node.val, new ArrayList()));
            while(!deque.isEmpty()){
                Node poll = deque.pollLast();
                for(Node neibe:poll.neighbors){
                    if(!hashset.containsKey(neibe)){
                        deque.offerFirst(neibe);
                        hashset.put(neibe,new Node(neibe.val, new ArrayList()));
                    }
                    hashset.get(poll).neighbors.add(hashset.get(neibe));
                }
            }
            return hashset.get(node);
        }
        return null;
    }

    /**
     * 深度优先搜索
     * @param args
     */
    private static HashMap <Node, Node> visited = new HashMap <> ();
    public static Node cloneGraph1(Node node) {
        if (node == null){
            return null;
        }
        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node,clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph1(neighbor));
        }
        return clone;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node.neighbors.add(node1);
        node.neighbors.add(node2);
        node1.neighbors.add(node);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node);
        node3.neighbors.add(node2);
        Node node4 = cloneGraph1(node);
        System.out.println(node4.neighbors.get(0).val + " " + node4.neighbors.get(1).val);
        System.out.println(node4.neighbors.get(0).neighbors.get(0).val + " " + node4.neighbors.get(0).neighbors.get(1).val);
        System.out.println(node4.neighbors.get(1).neighbors.get(0).val + " " + node4.neighbors.get(1).neighbors.get(1).val);
        System.out.println(node4.neighbors.get(0).neighbors.get(0).neighbors.get(0).val + " " + node4.neighbors.get(0).neighbors.get(0).neighbors.get(1).val);

    }
}

package leetCodeTest;

import java.util.HashMap;
import java.util.Map;

public class 复制带随机指针的链表 {
    public static void main(String[] args) {//[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node = new Node(7,null,null);
        node.next = new Node(13,null,node);
        node.next.next = new Node(11,null,null);
        node.next.next.next = new Node(10,null,node.next.next);
        node.next.next.next.next = new Node(1,null,node);
        node.next.next.random = node.next.next.next.next;

    }

    /**
     * 将整个随机链表看成一个图，复制第一个节点。然后对这个图同时使用两次深度遍历
     * 一个按照next走，一个按照random走。并且记录所经过的节点，并将经过的节点copy记录成新节点，
     * 当迭代时再次经过此节点的时候，则查询visited获得已经连接过的节点信息。
     */
    private static Map<Node,Node> visited = new HashMap();
    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (visited.containsKey(head))
            return visited.get(head);
        Node node = new Node(head.val,null,null);
        visited.put(head,node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}


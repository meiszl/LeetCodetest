package leetCodeTest;

import java.util.*;

public class LFU缓存 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }
}
class LFUCache {
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<> (capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        //得到key对应的node，如果node不存在就返回-1
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //从频次记录Map（freqMap）中更新对应节点的频次信息。
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        //根据key获得对应的value信息
        Node node = cache.get(key);
        if (node != null) {
            //如果value存在就更新value值并更新频次信息。
            node.value = value;
            freqInc(node);
        } else {
            //如果value不存在就判断当前缓存容量是否超限
            //如果缓存容量超限，则删除最近最少使用的node节点并删除对应的key-value对，并将容量减一
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            //然后根据key-value对建立新的node，并将该node加入缓存中，并将容量加一。
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    /**
     * 此方法用于更新freqMap中的LinkedHashSet中对应的node的频次。
     * @param node
     */
    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        //根据freq获取freqMap中的set集合
        LinkedHashSet<Node> set = freqMap.get(freq);
        //删除集合中的node元素
        set.remove(node);
        //如果该node的频次信息等于现在为止所有频次中的最小值，并且此时该set集合已经为空
        //就重新记录min最小值，因为此时频次所在的最小值set已经为空，所以最小频次已经变化成freq+1了。
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表，更改当前node的freq。
        node.freq++;
        //获得下一个频次所存储的set集合信息。
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        //如果下一个频次的set集合为空，就新建一个set集合用于存放新频次的node。
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        //将新频次的node加入新set集合中
        newSet.add(node);
    }

    /**
     * 此方法用于添加新的node进入freqMap中，
     * 新的node加入的时候频次为1所以加入freqMap中的最前端
     * @param node
     */
    void addNode(Node node) {
        //获得频次为1的set集合
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        //将新的node加入set集合中
        set.add(node);
        //因为新的频次进入所以最小频次就变成了1
        min = 1;
    }

    /**
     * 删除node的时候优先删除最小频次的set集合中的元素，
     * 并且由于添加的时候是以双向链表的形式添加的，
     * 所以最上面的就是最早访问的node，删除最早访问node即为最近最少访问的节点。
     * @return
     */
    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;//用于记录该node的频次信息

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
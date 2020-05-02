package leetCodeTest;

import java.util.*;

public class LRU缓存机制 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("cache.get(1) = " + cache.get(1));// 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println("cache.get(2) = " + cache.get(2));// 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println("cache.get(1) = " + cache.get(1));// 返回 -1 (未找到)
        System.out.println("cache.get(3) = " + cache.get(3));// 返回  3
        System.out.println("cache.get(4) = " + cache.get(4));// 返回  4
    }

}
/**
 * 使用队列与HashMap实现LRU缓存
 *
 */
//class LRUCache {
//    int capacity;
//    HashMap<Integer,Integer> map;
//    Queue<Integer> Queue;
//    public LRUCache(int capacity) {
//        map = new HashMap<>();
//        Queue = new LinkedList<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (!map.containsKey(key))
//            return -1;
//        Queue.remove(key);
//        Queue.offer(key);
//        return map.get(key);
//    }
//
//    public void put(int key, int value) {
//        map.put(key,value);
//        if (Queue.contains(key)){
//            Queue.remove(Integer.valueOf(key));
//            Queue.offer(key);
//        }else {
//            Queue.offer(key);
//            if (Queue.size() > capacity){
//                Integer poll = Queue.poll();
//                map.remove(poll);
//            }
//        }
//    }
//}

/**
 * 使用LinkedHashMap实现LRU缓存
 */
class LRUCache extends LinkedHashMap<Integer,Integer>{
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
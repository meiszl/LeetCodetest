package leetCodeTest;

import java.util.*;
import java.util.stream.IntStream;

public class 常数时间插入与删除与获取随机元素 {
    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();
        // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println("randomSet.insert(1) = " + randomSet.insert(1));
        // 返回 false ，表示集合中不存在 2 。
        System.out.println("randomSet.remove(2) = " + randomSet.remove(2));
        // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println("randomSet.insert(2) = " + randomSet.insert(2));
        // getRandom 应随机返回 1 或 2 。
        System.out.println("randomSet.getRandom() = " + randomSet.getRandom());
        // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println("randomSet.remove(1) = " + randomSet.remove(1));
        // 2 已在集合中，所以返回 false 。
        System.out.println("randomSet.insert(2) = " + randomSet.insert(2));
        // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
        System.out.println("randomSet.getRandom() = " + randomSet.getRandom());
    }
}

/**
 * 传统list方法，时间复杂度高
 */
//class RandomizedSet {
//    List<Integer> list;
//    /** Initialize your data structure here. */
//    public RandomizedSet() {
//        list = new LinkedList();
//    }
//
//    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//    public boolean insert(int val) {
//        if (list.contains(val))
//            return false;
//        list.add(val);
//        return true;
//    }
//
//    /** Removes a value from the set. Returns true if the set contained the specified element. */
//    public boolean remove(int val) {
//        return list.remove(Integer.valueOf(val));
//    }
//
//    /** Get a random element from the set. */
//    public int getRandom() {
//        Random random = new Random();
//        int i = random.nextInt(list.size());
//        return list.get(i);
//    }
//}

/**
 * 使用两个Hashmap代替List。
 */
class RandomizedSet {
    HashMap<Integer,Integer> map1;
    HashMap<Integer,Integer> map2;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map2.containsKey(val)) {
            return false;
        } else {
            int index = map1.size();
            map1.put(index, val);
            map2.put(val, index);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // 思路: 用尾部的节点覆盖要删除的节点, 删除尾部, 以维护下标
        if(map2.containsKey(val)){
            int lastIndex = map1.size() - 1;
            // 要删除的下标
            int index=map2.get(val);
            // 最后一个插入的value
            int value=map1.get(lastIndex);
            // 把最后一个value覆盖要删除的val
            map1.put(index,value);
            // 同时更新下标
            map2.put(value,index);
            // 删除尾部
            map1.remove(lastIndex);
            map2.remove(val);
            return true;
        }
        else{
            return false;
        }

    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (map1.size() == 0)
            return 0;
        int i = (int) (Math.random() * map1.size());
        return map1.get(i);
    }
}

package leetCodeTest;

import java.util.*;

public class 使数组的唯一最小增量 {
    public static void main(String[] args) {
        int[] A = new int[]{3,2,1,2,1,7};
        final int i = minIncrementForUnique(A);
        System.out.println("i = " + i);
    }

    /**
     * 先排序，然后遍历数组判断前一个数是否大于等于后一个数，
     * 如果这种情况成立则使用前一个数减去后一个数然后再+1。
     * 最后将得到的数字赋值给后一个数。如下实例，
     * 原数组：[1,1,2,2,3,7].经过5次循环比较得到如下结果。
     * Arrays.toString(A) = [1, 2, 2, 2, 3, 7]
     * Arrays.toString(A) = [1, 2, 3, 2, 3, 7]
     * Arrays.toString(A) = [1, 2, 3, 4, 3, 7]
     * Arrays.toString(A) = [1, 2, 3, 4, 5, 7]
     * Arrays.toString(A) = [1, 2, 3, 4, 5, 7]
     * @param A
     * @return
     */
    public static int minIncrementForUnique(int[] A) {
        // 先排序
        Arrays.sort(A);
        int move = 0;
        // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int pre = A[i];
                A[i] = A[i - 1] + 1;
                move += A[i] - pre;
            }
            System.out.println("Arrays.toString(A) = " + Arrays.toString(A));
        }
        return move;
    }
//    public static int minIncrementForUnique(int[] A) {
//        int i;
//        Map<Integer,Integer> map = new HashMap();
//        for (i=0;i<A.length;i++){
//            if (map.get(A[i])==null) {
//                map.put(A[i],1);
//                continue;
//            }
//            Integer integer = map.get(A[i]);
//            map.put(A[i], ++integer);
//        }
//        Set<Integer> set = map.keySet();
//        Object[] objects = set.toArray();
////        Iterator<Integer> iterator = set.iterator();
//        int coun=0;
//        //使用iterator遍历的时候不允许修改遍历对象中的值，如下情况不允许修改map的值
////        while (iterator.hasNext()){
//        for (i=0;i<objects.length;i++){
//            Integer next = (Integer) objects[i];
//            Integer integer = map.get(next);
//            while (integer!=1){
//                System.out.println("next = " + next);
//                if (!map.containsKey(++next))
//                {
//                    map.put(next,1);
//                    integer--;
//                    next = (Integer) objects[i];
//                }
//                coun++;
//            }
//        }
//        System.out.println("map = " + map);
//        return coun;
//    }
}

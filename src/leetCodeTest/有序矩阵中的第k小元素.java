package leetCodeTest;

import java.util.PriorityQueue;

public class 有序矩阵中的第k小元素 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        int i = kthSmallest(matrix, k);
        System.out.println("i = " + i);
    }

    /**
     * 大顶堆算法
     * @param matrix
     * @param k
     * @return
     */
//    public static int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                if (priorityQueue.size() == k && anInt > priorityQueue.peek())
//                    break;
//                priorityQueue.add(anInt);
//                if (priorityQueue.size() > k)
//                    priorityQueue.poll();
//            }
//        }
//        System.out.println("priorityQueue = " + priorityQueue);
//        return priorityQueue.poll();
//    }

    /**
     * 利用数组的排序特性进行查找
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;
        int left = matrix[0][0], right = matrix[n][n];
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = countNotMoreThanMid(matrix, mid, n);
            if(count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private static int countNotMoreThanMid(int[][] matrix, int mid, int n){
        int count = 0;
        int x = 0, y = n;
        while(x <= n && y >= 0){
            if(matrix[y][x] <= mid){
                count += y + 1;
                x++;
            }else{
                y--;
            }
        }
        return count;
    }
}

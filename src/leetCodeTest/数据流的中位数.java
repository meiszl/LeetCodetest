package leetCodeTest;

import java.util.*;

public class 数据流的中位数 {
    /*
    ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    [[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
//        medianFinder.addNum(-4);
//        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
//        medianFinder.addNum(-5);
//        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
    }

}

/**
 * 传统List做法
 */
//class MedianFinder {
//    List<Integer> list;
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        list = new ArrayList();
//    }
//
//    public void addNum(int num) {
//        list.add(num);
//    }
//
//    public double findMedian() {
//        list.sort((o1, o2) -> o1-o2);
//        double res = 0.0;
//        if (list.size()%2 == 0){
//            res = ((double)list.get(list.size()/2)+(double)list.get(list.size()/2-1))/2;
//        }else {
//            res = (double)list.get(list.size()/2);
//        }
//        return res;
//    }
//}

/**
 * 大顶堆小顶堆方法，将数组一分为二使用大顶堆与小顶堆存储数据可以直接求出中位数的值
 */
class MedianFinder {

    /**
     * 当前大顶堆和小顶堆的元素个数之和
     */
    private int count;
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        count = 0;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        minheap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count += 1;
        maxheap.offer(num);
        minheap.add(maxheap.poll());
        // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
        if ((count & 1) != 0) {
            maxheap.add(minheap.poll());
        }
    }

    public double findMedian() {
        System.out.println("minheap = " + minheap);
        System.out.println("maxheap = " + maxheap);
        if ((count & 1) == 0) {
            // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
            return (double) (maxheap.peek() + minheap.peek()) / 2;
        } else {
            // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
            return (double) maxheap.peek();
        }
    }
}

/**
 * 大顶堆与小顶堆方法。
 */
//class MedianFinder {
//    PriorityQueue<Integer> MinQue;
//    PriorityQueue<Integer> MaxQue;
//    int count;
//    /** initialize your data structure here. */
//
//    public MedianFinder() {
//        count = 0;
//        MinQue = new PriorityQueue<>();
//        MaxQue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
//    }
//
//    public void addNum(int num) {
//        count +=1;
//        MaxQue.offer(num);
//        MinQue.offer(MaxQue.poll());
//        if ((count & 1) != 0){
//            MaxQue.offer(MinQue.poll());
//        }
//    }
//
//    public double findMedian() {
//        System.out.println("MaxQue = " + MaxQue);
//        System.out.println("MinQue = " + MinQue);
//        return (count&1) != 0? (double)MaxQue.peek():(MaxQue.peek() + MinQue.peek())*0.5;
//    }
//}
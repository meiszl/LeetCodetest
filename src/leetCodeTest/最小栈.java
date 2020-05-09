package leetCodeTest;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class 最小栈 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        minStack.pop();
//        System.out.println("minStack.getMin() = " + minStack.getMin()); // --> 返回 -3.
        minStack.pop();
        System.out.println("minStack.getMin() = " + minStack.getMin());
//        System.out.println("minStack.top() = " + minStack.top());//  --> 返回 0.
//        System.out.println("minStack.getMin() = " + minStack.getMin());//  --> 返回 -2.

    }
}
/**
 * 小顶堆方法
 */
//class MinStack {
//    PriorityQueue<Integer> priorityQueue;
//    List<Integer> list;
//    /** initialize your data structure here. */
//    public MinStack() {
//        list = new LinkedList<>();
//        priorityQueue = new PriorityQueue<>();
//    }
//
//    public void push(int x) {
//        priorityQueue.add(x);
//        list.add(x);
//    }
//
//    public void pop() {
//        priorityQueue.remove(list.get(list.size()-1));
//        list.remove(list.size()-1);
//    }
//
//    public int top() {
//        return list.get(list.size()-1);
//    }
//
//    public int getMin() {
//        return priorityQueue.peek();
//    }
//}

/**
 * 循环选取法
 */
//class MinStack {
//    int min;
//    Stack<Integer> list;
//    /** initialize your data structure here. */
//    public MinStack() {
//        list = new Stack<>();
//        min = Integer.MAX_VALUE;
//    }
//
//    public void push(int x) {
//        if (x <= min){
//            list.push(min);
//            min = x;
//        }
//        list.push(x);
//    }
//
//    public void pop() {
//        if (list.pop() == min){
//            min = list.pop();
//        }
//    }
//
//    public int top() {
//        return list.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }
//}

/**
 * 数组法，双100
 */
class MinStack {
    private int[] Ele;
    private int length;
    private int real;
    private int Min;
    /** initialize your data structure here. */
    public MinStack() {
        this.real=1024;
        this.Ele=new int[this.real];
        this.length=0;
        this.Min=0;
    }

    public void push(int x) {
        int[] tmp=Ele;
        if(length==0)
            Min=x;
        if(length+1==real){
            Ele=new int[real*2];
            real*=2;
            System.arraycopy(Ele,0,tmp,0,real/2);
        }
        Ele[length]=x;
        length++;
        if(x<Min)
            Min=x;
    }

    public void pop() {
        length--;
        if(Ele[length]==Min){
            Min=Ele[0];
            for(int i=1;i<length;i++){
                if(Ele[i]<Min)
                    Min=Ele[i];
            }
        }
    }

    public int top() {
        return Ele[length-1];
    }

    public int getMin() {
        return Min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

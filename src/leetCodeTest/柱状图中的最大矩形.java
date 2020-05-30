package leetCodeTest;

import java.util.Stack;

public class 柱状图中的最大矩形 {
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        int i = largestRectangleArea(heights);
        System.out.println("i = " + i);
    }

    /**
     * 变化窗口滑动法，超时,暴力法
     * @param heights
     * @return
     */
//    public static int largestRectangleArea(int[] heights) {
//        if (heights == null||heights.length == 0) return 0;
//        int i,len,j;
//        int MaxCount = Integer.MIN_VALUE;
//        for (len = 1;len<=heights.length;len++){
//            for (i=0;i+len<=heights.length;i++){
//                int min = Integer.MAX_VALUE;
//                for (j=i;j<i+len;j++){
//                    min = Math.min(min,heights[j]);
//                }
//                MaxCount = Math.max(MaxCount,(min*len));
//            }
//        }
//        return MaxCount;
//    }
    /**
     * 优化暴力法2
     * @param heights
     * @return
     */
//    public static int largestRectangleArea(int[] heights) {
//        if (heights == null||heights.length == 0) return 0;
//        int maxarea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            for (int j = i; j < heights.length; j++) {
//                int minheight = Integer.MAX_VALUE;
//                for (int k = i; k <= j; k++)
//                    minheight = Math.min(minheight, heights[k]);
//                maxarea = Math.max(maxarea, minheight * (j - i + 1));
//            }
//        }
//        return maxarea;
//    }

    /**
     * 优化暴力法3
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }

    /**
     * 单调栈方法
     * 详解：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
     */
//    public static int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int MaxArea = 0;
//        for (int i = 0; i < heights.length; i++) {
//            while (stack.peek() != -1&&heights[stack.peek()] >= heights[i])
//                MaxArea = Math.max(MaxArea,heights[stack.pop()]*(i-1-stack.peek()));
//            stack.push(i);
//        }
//        while (stack.peek() != -1){
//            MaxArea = Math.max(MaxArea,heights[stack.pop()] * (heights.length - 1 - stack.peek()));
//        }
//        return MaxArea;
//    }

}


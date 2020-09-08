package leetCodeTest;

import java.util.*;

public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        int result[][] = findContinuousSequence(9);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    /**
     * 这个算法是真的牛逼，所以记录一下，来源于评论中的一个JAVA算法。
     * 一开始的时候，我考虑到了 target%i=0 的时候，i 是多少就有多少个元素在这个数组里面，
     * 但是我怎么也没想到把他们连在一起，而且我没法按照规律处理两个相邻的数字加在一起的情况。
     * 然后我看到了这段代码，豁然开朗，觉得有必要记录下来，感谢这位大哥。
     *
     * 这个题如果用滑动窗口，暴力方法去解决，是完全可以的，但是这道题的数学规律决定了他可以很快。
     *
     * 在这里，我们考虑以 9 为例子，9 可以被拆开成 4+5。
     *
     * 为了得到 4 我们需要思考一下。根据规律如果是 [4,5] 的话，i=2，target % 2 = 0
     * 其中 [4,5] 可以改写成 4+(4+1)。
     *
     * 在考虑三个元素的时候 2+3+4 我们发现他可以被写成 2+(2+1)+(2+2) target%3 = 0。
     * 似乎有点规律，我们不妨用 开始元素 x 元素个数 你会发现如果 target 刚好为这个值的话，
     * 也能满足 target%i=0。
     *
     * 那我们如何让 target 的值等于我们需要的值呢？
     *
     * 根据刚才的变式，我们发现只要让 target 逐次减去 (1,2,3,....)
     * 并且当 target%i = 0 的时候返回这个 target/i 就是我们需要的值了。
     *
     * 作者：VaporMax
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/java-shuang-100-by-vapormax/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;

        while(target>0)
        {
            target -= i++;
            if(target>0 && target%i == 0)
            {
                int[] array = new int[i];
                for(int k = target/i, j = 0; k < target/i+i; k++,j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }
}

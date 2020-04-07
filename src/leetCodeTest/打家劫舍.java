package leetCodeTest;

public class 打家劫舍 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int rob = rob(nums);
        System.out.println("rob = " + rob);
    }

    /**
     * 传统线性规划方法，每一位与前面i-1位的值分别相加，然后取得结果最大值添加到sum数组中。
     * @param num
     * @return
     */
//    public static int rob(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        if (nums.length == 1)
//            return nums[0];
//        int i,j,temp;
//        int[] sum = new int[nums.length];
//        sum[0] = nums[0];
//        sum[1] = nums[1];
//        temp = Math.max(nums[0],nums[1]);
//        for (i=2;i<nums.length;i++){
//            for (j=0;j<i-1;j++){
//                sum[i] = Math.max(sum[i],sum[j] + nums[i]);
//            }
//            temp = Math.max(temp,sum[i]);
//        }
//        System.out.println(Arrays.toString(sum));
//        return temp;
//    }

    /**
     * 考虑所有可能的抢劫方案过于困难。一个自然而然的想法是首先从最简单的情况开始。记：
     *
     * f(k) = 从前 k 个房屋中能抢劫到的最大数额，A_i = 第 i 个房屋的钱数。
     * 首先看 n = 1 的情况，显然 f(1) = A_1。
     * 再看 n = 2，f(2) = max(A_1,A_2)。
     * 对于 n = 3，有两个选项:
     * 1.抢第三个房子，将数额与第一个房子相加。
     *
     * 2.不抢第三个房子，保持现有最大数额。
     * 显然，你想选择数额更大的选项。于是，可以总结出公式：
     * f(k) = max(f(k – 2) + A_k,f(k – 1))
     * 我们选择 f(–1) = f(0) = 0 为初始情况，这将极大地简化代码。
     * 答案为 f(n)。可以用一个数组来存储并计算结果。不过由于每一步你只需要前两个最大值，
     * 两个变量就足够用了。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public static int rob(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        int temp;
        for (int x : num) {
            temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

}

package leetCodeTest;

import java.util.Arrays;

public class 最长上升子序列 {

    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        final int i = lengthOfLIS(nums);
        System.out.println("i = " + i);
    }

    /**
     * 解题思路：
     * 降低复杂度切入点： 解法一中，遍历计算 dp 列表需 O(N)，计算每个 dp[k] 需 O(N)。
     *
     * 动态规划中，通过线性遍历来计算 dp 的复杂度无法降低；
     * 每轮计算中，需要通过线性遍历 [0,k) 区间元素来得到 dp[k] 。我们考虑：是否可以通过重新设计状态定义，使整个 dp 为一个排序列表；
     * 这样在计算每个 dp[k] 时，就可以通过二分法遍历 [0,k) 区间元素，将此部分复杂度由 O(N) 降至 O(logN)。
     * 设计思路：
     *
     * 新的状态定义：
     * 我们考虑维护一个列表 tails，其中每个元素 tails[k] 的值代表 长度为 k+1 的子序列尾部元素的值。
     * 如 [1,4,6] 序列，长度为 1,2,3 的子序列尾部元素值分别为 tails = [1,4,6]。
     * 状态转移设计：
     * 设常量数字 N，和随机数字 x，我们可以容易推出：当 N 越小时，N<x 的几率越大。例如： N=0 肯定比 N=1000 更可能满足 N<x。
     * 在遍历计算每个 tails[k]，不断更新长度为 [1,k] 的子序列尾部元素值，始终保持每个尾部元素值最小 （例如 [1,5,3]]， 遍历到元素 5 时，
     * 长度为 2 的子序列尾部元素值为 5；当遍历到元素 3 时，尾部元素值应更新至 3，因为 3 遇到比它大的数字的几率更大）。
     * tails 列表一定是严格递增的： 即当尽可能使每个子序列尾部元素值最小的前提下，子序列越长，其序列尾部元素值一定更大。
     * 反证法证明： 当 k < i，若 tails[k] >= tails[i]，代表较短子序列的尾部元素的值 > 较长子序列的尾部元素的值。
     * 这是不可能的，因为从长度为 i 的子序列尾部倒序删除 i-1 个元素，剩下的为长度为 k 的子序列，设此序列尾部元素值为 v，
     * 则一定有 v<tails[i] （即长度为 k 的子序列尾部元素值一定更小）， 这和 tails[k]>=tails[i] 矛盾。
     * 既然严格递增，每轮计算 tails[k] 时就可以使用二分法查找需要更新的尾部元素值的对应索引 i。
     *
     * 状态定义：
     *
     * tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值。
     * 转移方程： 设 resres 为 tails 当前长度，代表直到当前的最长上升子序列长度。设 j∈[0,res)，考虑每轮遍历 nums[k] 时，通过二分法遍历 [0,res) 列表区间，找出 nums[k] 的大小分界点，会出现两种情况：
     *
     * 区间中存在 tails[i] > nums[k] ： 将第一个满足 tails[i] > nums[k] 执行 tails[i] = nums[k] ；因为更小的 nums[k] 后更可能接一个比它大的数字（前面分析过）。
     * 区间中不存在 tails[i] > nums[k] ： 意味着 nums[k] 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 res ），新子序列长度为 res + 1。
     * 初始状态：
     *
     * 令 tails列表所有值 =0。
     * 返回值：
     *
     * 返回 res ，即最长上升子序列长度。
     * 复杂度分析：
     * 时间复杂度 O(NlogN) ： 遍历 nums 列表需 O(N)，在每个 nums[i] 二分法需 O(logN)。
     * 空间复杂度 O(N) ： tails 列表占用线性大小额外空间。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int res = 0;
            for(int num : nums) {
                int i = 0, j = res;
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                while(i < j) {
                    int m = (i + j) / 2;
                    if(tails[m] < num) i = m + 1;
                    else j = m;
//                    System.out.println("m = " + m);
                }
                tails[i] = num;
                System.out.println(Arrays.toString(tails));
                if(res == j) res++;
                System.out.println("res = " + res);
            }
            return res;
    }
}

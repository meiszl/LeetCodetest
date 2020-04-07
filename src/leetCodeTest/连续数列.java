package leetCodeTest;


public class 连续数列 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,3};
        int i = maxSubArray(nums);
        System.out.println("i = " + i);
    }
    /**
     * 暴力匹配，超时
     */
//    public static int maxSubArray(int[] nums) {
//        if (nums.length == 0){
//            return 0;
//        }
//        if (nums.length == 1){
//            return nums[0];
//        }
//        int i,len,j;
//        int su;
//        int sum = Integer.MIN_VALUE;
//        for (len = 1;len<=nums.length;len++){
//            for (i=0;i+len<=nums.length;i++){
//                su = 0;
//                for (j=i;j<i+len;j++){
//                    su += nums[j];
//                }
//                if (su > sum)
//                    sum = su;
//            }
//        }
//        return sum;
//    }

    /**
     * 首先假设每次都从遍历的位置开始构建序列，那么在这种情况下需要考虑两种情况：
     * 1.当前位置的值大于之前的序列和，在这种情况下需要从当前位置从新开始构建序列。
     * 2.当前位置的值小于之前的序列和，在这种情况下需要继续构造之前的序列。
     * 此题中，动态规划的状态转移就是当前位置的值与之前序列值的大小是否相等。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int i,temp = nums[0];//初始状态时，以第一个nums值为初始序列和。
        int[] sum = new int[nums.length];//用来存储遍历时的序列信息
        //在未遍历时，所有的点都有可能成为序列的开头
        for (i=0;i<nums.length;i++){
            sum[i] = nums[i];
        }
        for (i=1;i<nums.length;i++){
            //判断当前的nums值+之前的序列和与当前的nums值之间哪个大，并将较大的值存入sum中作为下一步判断的节点信息。
            sum[i] = Math.max(nums[i] + sum[i-1],sum[i]);
            //存储所有序列和中的最大值
            if (sum[i]> temp)
                temp = sum[i];
        }
        return temp;
    }
}

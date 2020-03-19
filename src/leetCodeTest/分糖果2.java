package leetCodeTest;

import java.util.Arrays;

public class 分糖果2 {

    public static void main(String[] args) {
        int candies = 10;
        int num_people = 3;
        final int[] distributeCandies = distributeCandies(candies, num_people);
//        final int[] distributeCandies = distributeCandies1(candies, num_people);
        System.out.println("Arrays.toString(distributeCandies) = " + Arrays.toString(distributeCandies));
    }

    /**
     * 普通方法：
     * 直接模拟分糖果的过程，使用三个变量或者两个变量均可，此处给出的三个变量的实例
     * ps：该方法耗时2ms，内存消耗37MB。
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies(int candies, int num_people) {
            int sum = 1;
            int i = 0;
            int ans[] = new int[num_people];//JAVA数组创建时未填充的位置默认为0
            while (candies>0){
                if ((candies - sum) > 0){
                    ans[i] += sum;
                    candies -= sum;
                    sum += 1;
                } else {
                    ans[i] += candies;
                    candies = 0;
                }
                if (i == num_people-1){
                    i = 0;
                }else {
                    i++;
                }
            }
            return ans;
    }

    /**
     * 高端方法：
     * 观察数字关系，得出剩余糖果对人数求余即为result数组的下标，
     * 然后使用Math.min函数求剩余糖果与当前糖果总数的最小值加入到result数组中，
     * 反复迭代得出最终结果。
     * ps：然而此方法不如传统方法内存消耗低，该方法用时3ms，内存消耗37.1MB....（这个内存可能测的有问题）
     * @param candies
     * @param num_people
     * @return
     */
    public static int[] distributeCandies1(int candies, int num_people) {
        int curr_give = 0;
        int[] res = new int[num_people];

        while (candies > 0) {

            res[curr_give % num_people] += Math.min(++curr_give, candies);
            candies -= curr_give;
        }

        return res;
    }
}

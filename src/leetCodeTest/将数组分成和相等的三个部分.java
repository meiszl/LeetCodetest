package leetCodeTest;

public class 将数组分成和相等的三个部分 {

    public static void main(String[] args) {
        int a[] = {0,2,1,-6,6,-7,9,1,2,0,1};
        final boolean b = canThreePartsEqualSum(a);
        System.out.println("b = " + b);
    }

    /**
     * 数组元素的总和 sum 不是3的倍数，直接返回false
     * 使用双指针left，right, 从数组两头开始一起找，节约时间
     * 当 left + 1 < right 的约束下，可以找到数组两头的和都是 sum/3,那么中间剩下的元素和就一定也是sum/3
     * （left + 1 < right的约束就是要中间有剩下的元素，使用left < right的约束，
     * 数组可能可以恰好被划分成两部分，中间没有元素）
     *
     * 作者：sugar-31
     * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/solution/java-shi-yong-shuang-zhi-zhen-by-sugar-31/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param A
     * @return
     */
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while(left + 1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if(leftSum != sum/3){
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if(rightSum != sum/3){
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }

}

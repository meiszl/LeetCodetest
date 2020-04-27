package leetCodeTest;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        int target = 3;
        int search = search(nums, target);
        System.out.println("search = " + search);
//        int point = findPoint(nums);
//        System.out.println("point = " + point);
    }

    /**
     * 普通循环查找，通过。
     * @param nums
     * @param target
     * @return
     */
//    public static int search(int[] nums, int target) {
//        if(nums == null || nums.length == 0) return -1;
//        if (nums.length == 1) return nums[0] == target? 0:-1;
//        for (int i = 0; i < nums.length; i++) {
//            if (target == nums[i])
//                    return i;
//        }
//        return -1;
//    }
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target? 0:-1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left<=right){
            mid = (left + right) >>> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]){
                if (target>= nums[left] && target <nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
//    public static int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        int start = 0;
//        int end = nums.length - 1;
//        int mid;
//        while (start <= end) {
//            mid = start + (end - start) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            }
//            //前半部分有序,注意此处用小于等于
//            if (nums[start] <= nums[mid]) {
//                //target在前半部分
//                if (target >= nums[start] && target < nums[mid]) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            } else {
//                if (target <= nums[end] && target > nums[mid]) {
//                    start = mid + 1;
//                } else {
//                    end = mid - 1;
//                }
//            }
//        }
//        return -1;
//
//    }

}


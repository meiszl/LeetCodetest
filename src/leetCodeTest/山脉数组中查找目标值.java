package leetCodeTest;

import util.MountainArray;


public class 山脉数组中查找目标值 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,5,3,1};
        int target = 3;
        MountainArray mountainArray = new MountainArray(nums);
        int inMountainArray = findInMountainArray(target,mountainArray);
        System.out.println("inMountainArray = " + inMountainArray);
    }

    /**
     * 三次二分查找，首先找到中间位置，然后将数组分成两半分别进行二分查找。
     * @param target
     * @param mountainArr
     * @return
     */
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
        int mid;
        while (left < right){
            mid = (left + right) >> 1;
            int midnums = mountainArr.get(mid);
            int Mid1nums = mountainArr.get(mid + 1);
            if (Mid1nums < midnums){
                right = mid;
            } else if (Mid1nums > midnums){
                left = mid + 1;
            }
        }
        if (mountainArr.get(left) == target)
            return left;
        mid = left;
        int temmid = mid;
        left = 0;
        right = mountainArr.length() - 1;
        int leftmid;
        int rightmid;
        while (left <= mid){
            leftmid = (left + mid) >> 1;
            int lemid = mountainArr.get(leftmid);
            if (lemid < target){
                left = leftmid + 1;
            }else if (lemid > target){
                mid = leftmid - 1;
            }else if (lemid == target){
                return leftmid;
            }
        }
        mid = temmid;
        while (mid <= right){
            rightmid = (mid + right) >> 1;
            int rimid = mountainArr.get(rightmid);
            if (rimid < target){
                right = rightmid - 1;
            }else if (rimid > target){
                mid = rightmid + 1;
            }else if (rimid == target){
                return rightmid;
            }
        }
        return -1;
    }
}

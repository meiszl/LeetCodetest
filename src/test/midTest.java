package test;

public class midTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,4,4,5,5,6,6,7,7};
//        int i = findmidUp(arr, 4);
//        System.out.println(i);
        findNums(arr);
    }
    //找寻左上界
    public static int findmidUp(int[] arr,int target){
        int left = 0,right = arr.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) >>> 1;
            if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (arr[left] == target)
            return left;
        return -1;
    }
    //找寻右上界
    public static int findmiddown(int[] arr,int target){
        int left = 0,right = arr.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) >>> 1;
            if (arr[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        if (arr[left] == target)
            return left;
        return -1;
    }
    public static void findNums(int[] array){
        if (array == null)
            return;
        int num1 = 0;
        int num2 = 0;
        int number = array[0];
        for (int i = 1; i < array.length; i++) {
            number ^= array[i];
        }
        int index = 0;
        while ((number & 1) == 0){
            number = number >> 1;
            index++;
        }
        for (int i = 0; i < array.length; i++) {
            boolean isBit = ((array[i] >> index)& 1) == 0;
            if (isBit){
                num1 ^= array[i];
            }else {
                num2 ^= array[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }
}

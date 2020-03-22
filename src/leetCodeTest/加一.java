package leetCodeTest;

import java.util.Arrays;

public class 加一 {
    public static void main(String[] args) {
        int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] ints = plusOne(digits);
        System.out.println("ints = " + Arrays.toString(ints));
    }
    /**
     * 直接运算的方法，直接将数组最后一位拿出进行运算并记录进位值
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int i;
        int flag = 0;
        for (i=digits.length-1;i>=0;i--){
            if (i==digits.length-1){
                digits[i]++;
            }
            if (flag !=0){
                digits[i] = digits[i] + flag;
                flag = 0;
            }
            if (digits[i] >= 10){
                digits[i] = digits[i] - 10;
                flag = 1;
            }
        }
        if (flag == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (i=0;i<digits.length;i++)
                res[i+1] = digits[i];
            return res;
        }
        return digits;
    }
}

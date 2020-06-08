package test;

import java.util.Arrays;
import java.util.Scanner;

public class qianxinMain1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] nums = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        sum1 = nums[0] + nums[1] + nums[2] + nums[3];
        sum2 = nums[3] + nums[4] + nums[5] + nums[6];
        sum3 = nums[0] + nums[6] + nums[7] + nums[8];
        if(sum1 == sum2&&sum2 == sum3&&sum3 == sum1){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}

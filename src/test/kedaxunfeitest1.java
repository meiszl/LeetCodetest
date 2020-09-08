package test;

import java.util.Arrays;
import java.util.Scanner;

public class kedaxunfeitest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(",");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
//        quickSort(nums,0,n-1);
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != n-1)
                System.out.print(nums[i] + " ");
            else
                System.out.println(nums[i]);
        }
    }
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if (low >high){
            return;
        }
        i = low;
        j = high;
        temp = arr[low];
        while (i<j){
            while (temp <= arr[j]&&j<j){
                j--;
            }
            while (temp >= arr[i] && i<j){
                i++;
            }
            if(i<j){
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr,low,j-1);
        quickSort(arr,j+1,high);
    }
}

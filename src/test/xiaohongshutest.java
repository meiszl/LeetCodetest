package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class xiaohongshutest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(_boxes);
        System.out.println(String.valueOf(res));

    }
    private static int maxBoxes(int[][] boxes) {
        Arrays.sort(boxes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] secondDim = new int[boxes.length];
        for (int i = 0; i < boxes.length; i++) {
            secondDim[i] = boxes[i][1];
        }
        return lengthOfLIS(secondDim);
    }
    private static int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp,0,len,num);
            if (i<0){
                i = -(i+1);
            }
            dp[i] = num;
            if (i == len){
                len++;
            }
        }
        return len;
    }
}

package OfferTest;

import java.util.Arrays;
import java.util.HashMap;

public class mergeSort {
    private static int[] res;
    private static int[] index;
    public static void merge(int[] a,int left,int mid,int right){
        int[] tmp = new int[a.length];
        int[] in = new int[a.length];
        int p1 = left,p2 = mid + 1,k = left;
        while (p1<=mid&&p2<=right){
            if (a[p1]<=a[p2]){
                tmp[k] = a[p1];
                in[k++] = index[p1++];
            } else{
                int te = p1,j = 1;
                for (int i = te; i <= mid; i++) {
                    res[index[te++]] += j;
                }
//                res[map.get(a[p1])] += mid-left+1;
                tmp[k] = a[p2];
                in[k++] = index[p2++];
            }
        }
        while (p1<=mid) tmp[k++]=a[p1++];
        while (p2<=right) tmp[k++]=a[p2++];
        for (int i = left; i <= right; i++) {
                a[i] = tmp[i];
                index[i] = in[i];
        }
    }
    public static void mergeso(int[] a,int start,int end){
        if (start < end){
            int mid = start + (end - start) >>> 1;
            mergeso(a,start,mid);
            mergeso(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }
    public static void main(String[] args) {
//        int[] a = {49,38,65,97,76,13,27,50};
        //求解逆序对
        int[] a = {0,2,1};
        index = new int[a.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        res = new int[a.length];
        mergeso(a,0,a.length-1);
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
    }
}

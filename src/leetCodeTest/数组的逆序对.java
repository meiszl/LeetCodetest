package leetCodeTest;

import java.util.Arrays;

public class 数组的逆序对 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        int i = reversePairs(nums);
        System.out.println("i = " + i);
    }

    /**
     * 剑指offer原方法，归并排序，出错
     */
    private static int count = 0;
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        mergeSort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return count;
    }
    private static void mergeSort(int[] data,int start,int end) {
        int mid = start + (end - start) / 2;
        if (start < end) {
            mergeSort(data, start, mid);
            mergeSort(data, mid + 1, end);
            merge(data,start,mid,end);
        }
    }
    private static void merge(int[] data,int start, int mid, int end){
        int[] arr = new int[end - start + 1];
        int c = 0;
        int s = start;
        int index = mid + 1;
        while (start <= mid && index <= end){
            if (data[start] > data[index]){
                arr[c++] = data[index++];
                // 最后分割的时候，如果右边的数组某一位index小于左边的数组，
                // 由于数组分治所得的结果是已经排好序的，
                // 所以右边数组的index位必然大于左边数组的start位以及start位右侧的所有数字。
                // 例,[7564],分治所得[75],[64]。根据归并排序判断结果可以统计这两个小数组的情况
                // 为[57],[46]，所以就得到了[75]与[64]两个子数组的逆序([75]的逆序数量为1,[64]的逆序数量为1),
                // 即两边的逆序均为count += 1（此时start = 0,mid = 0,end = 1）,然后归并得到数组[5746]，
                // 然后归并判断,此时由于5<4，所以具有逆序[54]，又因为左侧是排好序的数组所以可以知道
                // 左侧数组中在5右边的数也可以与4构成逆序，即[74]。所以判断5位置的时候存在两个逆序即[54],[74]。
                // 然后右侧指针移动继续判断，由于6>5，所以左侧指针移动由于7>6，所以存在逆序[76].
                // 由此可以知道每次判断所得的逆序数量为mid+1-start（即当右侧数组中存在一个值j
                // 比左侧数组中的某一个值i大的时候，由于左侧数组的有序性可以知道左侧数组中
                // 从i往后的值均可以与j构成逆序，所以共有左侧数组的长度-i位置下标个逆序）
                count += mid + 1 - start;
                System.out.println("count = " + count);
            }else {
                arr[c++] = data[start++];
            }
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        while (start <= mid){
            arr[c++] = data[start++];
        }
        while (index <= end){
            arr[c++] = data[index++];
        }
        for (int d: arr){
            data[s++] = d;
        }
    }

    // 最后分割的时候，如果右边的数组某一位index小于左边的数组，
    // 由于数组分治所得的结果是已经排好序的，
    // 所以右边数组的index位必然大于左边数组的start位以及start位右侧的所有数字。
    // 例,[7564],分治所得[75],[64]。根据归并排序判断结果可以统计这两个小数组的情况
    // 为[57],[46]，所以就得到了[75]与[64]两个子数组的逆序([75]的逆序数量为1,[64]的逆序数量为1),
    // 即两边的逆序均为count += 1（此时start = 0,mid = 0,end = 1）,然后归并得到数组[5746]，
    // 然后归并判断,此时由于5<4，所以具有逆序[54]，又因为左侧是排好序的数组所以可以知道
    // 左侧数组中在5右边的数也可以与4构成逆序，即[74]。所以判断5位置的时候存在两个逆序即[54],[74]。
    // 然后右侧指针移动继续判断，由于6>5，所以左侧指针移动由于7>6，所以存在逆序[76].
    // 由此可以知道每次判断所得的逆序数量为mid+1-start（即当右侧数组中存在一个值j
    // 比左侧数组中的某一个值i大的时候，由于左侧数组的有序性可以知道左侧数组中
    // 从i往后的值均可以与j构成逆序，所以共有左侧数组的长度-i位置下标个逆序）
    /**
     * 归并排序，另外一个版本
     * @param nums
     * @return
     */
//    public static int reversePairs(int[] nums) {
//        int len=nums.length;
//        if(len==0)
//            return 0;
//        return digui(nums,0,len-1);
//    }
//    public static int digui(int[] nums,int left,int right){
//        if(left>=right)
//            return 0;
//        int mid=(right+left)>>1;
//        int l=digui(nums,left,mid);//记录左边的结果
//        int r=digui(nums,mid+1,right);//记录右边的结果
//        return (l+r+mergesort(nums,left,mid,right));//左+右+当前
//
//    }
//    public static int mergesort(int[]nums,int left,int mid,int right){
//        int[]temp=new int[right-left+1];//left和right都可以取到，所以需要加1
//        int ans=0;
//        int cur1=mid;
//        int cur2=right;
//        int cur3=right-left;
//        while(cur1>=left&&cur2>=mid+1){
//            if(nums[cur1]<=nums[cur2]){
//                temp[cur3--]=nums[cur2--];
//            }
//            else{
//                temp[cur3--]=nums[cur1--];
//                ans+=(cur2-mid);//比当前cur2里面的元素都大
//            }
//        }
//        while(cur1>=left){
//            temp[cur3--]=nums[cur1--];
//        }
//        while(cur2>=mid+1){
//            temp[cur3--]=nums[cur2--];
//        }
//        int x=0;
//        while(left<=right){
//            nums[left++]=temp[x++];
//        }
//        return ans;
//    }

    /**
     * 归并方法3
     * @param array
     * @return
     */
//    public static int InversePairs(int [] array) {
//        if(array==null||array.length<2)
//            return 0;
//        return MergeSort(array, 0, array.length-1);
//    }
//    public static int MergeSort(int[] arr, int left, int right){
//        //base case
//        if(left==right)
//            return 0;
//        //
//        int mid = left + ((right - left) >> 1);
//        int leftRes = MergeSort(arr, left, mid); //左部分逆序对的数量
//        int rightRes = MergeSort(arr, mid+1, right);//右部分逆序对的数量
//        int mergeRes = Merge(arr, left, mid, right);//归并左右部分产生的逆序对数量
//        return (leftRes + rightRes + mergeRes)%1000000007;
//    }
//    public static int Merge(int[] arr, int left, int mid, int right){
//        //create auxiliary arr
//        int[] help = new int[right - left + 1];
//        //create pointer
//        int p1=left, p2=mid+1, i=0;
//        //create res
//        int res=0;
//        //start merging
//        while(p1 <= mid && p2 <=right){
//            if(arr[p1] > arr[p2]){
//                res += right - p2 + 1; //arr[p1] 比arr[p2]大的话,比它后面所有的数都大
//                res = res%1000000007; //不加这句,对于大数组的案例就通过不了了; 本来我是加在return中的,后来发现报错才加在这里的
//                help[i++] = arr[p1++];
//            }
//            else{
//                help[i++] = arr[p2++];
//            }
//        }
//        //ensure merging finished
//        while(p1<=mid)
//            help[i++] = arr[p1++];
//        while(p2<=right)
//            help[i++] = arr[p2++];
//        //last step: help ==> arr
//        for(int k=0; k<help.length; k++)
//            arr[left++] = help[k];
//        return res;
//    }
}

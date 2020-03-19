package leetCodeTest;


public class 合并排序数组 {
    public static void main(String[] args) {
        int a[] = {1,2,3,0,0,0};
        int m = 3;
        int b[] = {2,5,6};
        int n = 3;
        merge(a,m,b,n);
    }

    /**
     * 算法思路，由于数组A与数组B都是已经排好序的数组，我们只需要将两个数组从后往前比较，
     * 将最大的结果倒序插入到数组A中，例如该程序中，A、B均含有三个数字则比较A[2]是否小于B[2],
     * 如果小于，就将B[2]赋值给A[5],然后继续比较A[2]与B[1]，根据结果将B中的值放入到A[4]，以此类推，
     * 直到出现A[2]大于B[0],如果出现这种情况就将A[2]放入到现在的A[3],然后继续比较A[1]与B[0],
     * 直到A[1]=B[0]就将B[0]放入A[2]，合并完成。
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        //得到数组末尾的下标
        int k = m+n-1,i=m-1,j=n-1;
//        System.out.println("1A = " + Arrays.toString(A) + " k = " + k + " j = " + j + " i = " + i);
        //判断下标是否为负数，即运算是否完成
        while(i>=0&&j>=0) {
            //如果A数组值小于B就将B中数据填充到A末尾
            if (A[i]<B[j]) {
                A[k--]=B[j--];
//                System.out.println("1A = " + Arrays.toString(A) + " k = " + k + " j = " + j + " i = " + i);
            //如果A数组值大于B就将A中元素向后填充
            }else {
                A[k--]=A[i--];
//                System.out.println("2A = " + Arrays.toString(A) + " k = " + k + " j = " + j + " i = " + i);
            }
        }
        //如果A数组的值全部大于B数组则需要将B数组整体移入A数组前端
        while(j>=0) {
            A[k--] = B[j--];
//            System.out.println("3A = " + Arrays.toString(A) + " k = " + k + " j = " + j + " i = " + i);
        }
    }
}

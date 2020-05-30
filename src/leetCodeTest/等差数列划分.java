package leetCodeTest;

import java.util.List;

public class 等差数列划分 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3};
        int i = numberOfArithmeticSlices(A);
        System.out.println("i = " + i);
    }

    /**
     * 滑动窗口暴力匹配法。
     * @param A
     * @return
     */
//    public static int numberOfArithmeticSlices(int[] A) {
//        if (A== null||A.length == 0) return 0;
//        int len,i,j,res = 0;
//        for (len = 3;len<=A.length;len++){
//            for (i=0;i+len<=A.length;i++){
//                int tem = 0;
//                for (j=i+1;j<i+len;j++){
//                    if (j==i+1){
//                        tem = A[j] - A[i];
//                        continue;
//                    }
//                    if (A[j] - A[j-1] != tem){
//                        i = j-1;
//                        break;
//                    }
//                    if (j == i+len - 1){
//                        System.out.println(j);
//                        res++;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 回溯算法。
     * @param A
     * @return
     */
    private static int res;
    private static int[] numsd;
    public static int numberOfArithmeticSlices(int[] A) {
        if (A==null||A.length < 3)return 0;
        numsd = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            numsd[i] = A[i] - A[i-1];
        }
        int temd = numsd[1],count = 1;
        int all = 0;
        for (int i = 2; i < numsd.length; i++) {
            if (numsd[i] == temd){
                count++;
            }else {
                temd = numsd[i];
                all = 0;
                for (int j = 1; j <= count-1; j++) {
                    all = all+j;
                }
                res += all;
                count = 1;
            }
        }
        if (temd == numsd[numsd.length-2]){
            all = 0;
            for (int j = 1; j <= count-1; j++) {
                all = all+j;
            }
            res += all;
        }
        return res;
    }
}

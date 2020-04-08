package leetCodeTest;


import java.util.Arrays;

public class 三步问题 {
    public static void main(String[] args) {
        int i = waysToStep(76);
        System.out.println("i = " + i);
    }
    public static int waysToStep(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        if (n== 3)
            return 4;
        int[] sum = new int[n];
        sum[0] = 1;
        sum[1] = 2;
        sum[2] = 4;
        int i;
        for (i=3;i<n;i++){
            if(i-1>=0){
                sum[i] = (sum[i-1]%1000000007) ;
            }
            if(i-2>=0){
                sum[i] = (sum[i]+(sum[i-2]%1000000007))%1000000007 ;
            }
            if(i-3>=0){
                sum[i] = (sum[i]+(sum[i-3]%1000000007))%1000000007 ;
            }

        }
        System.out.println(Arrays.toString(sum));
        return sum[sum.length-1]%1000000007;
    }
}

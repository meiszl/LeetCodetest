package leetCodeTest;

public class 牛妹的蛋糕 {
    public static void main(String[] args) {
        int i = cakeNumber(5);
        System.out.println("i = " + i);
    }
    public static int cakeNumber (int n) {
        // write code here
        int sum = n-1;
        float res = 1;
        int i;
        for (i=0;i<sum;i++){
            res = (float) Math.floor((res+1)/2 * 3);
            System.out.println(res);
        }
        return  (int) Math.floor(res);
    }
}

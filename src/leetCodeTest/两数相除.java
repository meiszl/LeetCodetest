package leetCodeTest;

public class 两数相除 {
    public static void main(String[] args) {//-2147483648 -1
        int dividend = -2147483648,divisor = -1 ;
        int divide = divide(dividend, divisor);
        System.out.println("divide = " + divide);
    }

    /**
     * 传统减法，超时。
     * @param dividend
     * @param divisor
     * @return
     */
//    public static int divide(int dividend, int divisor) {
//        int count = 0;
//        boolean divenfl = false;
//        if ((dividend<0 && divisor>0) || (dividend>0 && divisor<0)) {
//            divisor = -divisor;
//            divenfl = true;
//        }
//        while ((dividend > 0&& (dividend >= divisor)) || (dividend < 0&&(dividend<=divisor))){
//            dividend = dividend - divisor;
//            count += 1;
//            if (count >= Integer.MAX_VALUE)
//                return Integer.MAX_VALUE;
//        }
//        if (divenfl)
//            count = -count;
//        return count;
//    }

    /**
     * 位移算法
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        Boolean sign = (dividend >0)^(divisor>0);
        if (dividend>0)
            dividend = -dividend;
        if (divisor > 0){
            divisor = - divisor;
        }
        int res = 0;
        while (dividend <= divisor){
            int temdivsor = divisor;
            int temres = -1;
            while (dividend <= (temdivsor << 1)){
                if (temdivsor <= (Integer.MIN_VALUE >> 1)) break;
                temdivsor = temdivsor << 1;
                temres = temres << 1;
            }
            dividend = dividend - temdivsor;
            res += temres;
        }
        if (!sign){
            if (res <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            res = -res;
        }
        return res;
    }
}

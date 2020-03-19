package leetCodeTest;

public class 矩形重叠 {
    public static void main(String[] args) {
        int rec1[] = new int[]{0,0,1,1};
        int rec2[] = new int[]{1,0,2,1};
        final boolean rectangleOverlap = isRectangleOverlap(rec1, rec2);
        System.out.println("rectangleOverlap = " + rectangleOverlap);
    }

    /**
     * 矩形重叠问题，如果矩形不重叠则有如下四种情况（两个矩形由A,B标识）：
     * B矩形的右上角横坐标小于等于A矩形左下角横坐标，
     * B矩形的左下角横坐标大于等于A矩形右上角横坐标，
     * B矩形的右上角纵坐标小于等于A矩形左下角横坐标，
     * B矩形的左下角横坐标大于等于A矩形右上角横坐标。
     * 不满足以上条件的情况均为重叠情况。
     * @param rec1
     * @param rec2
     * @return
     */
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[2]<=rec1[0]||rec2[0]>=rec1[2]||rec2[1]>=rec1[3]||rec2[3]<=rec1[1]){
            return false;
        }else {
            return true;
        }

    }
}

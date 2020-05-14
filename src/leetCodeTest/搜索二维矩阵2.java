package leetCodeTest;

public class 搜索二维矩阵2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {1,   4,  7, 11, 12},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
                {-5},{-2}
        };
        int target = 0;
        boolean b = searchMatrix(matrix, target);
        System.out.println("b = " + b);
    }

    /**
     * 二分查找，注意边界问题。
     * @param matrix
     * @param target
     * @return
     */
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null|| matrix.length == 0||matrix[0].length == 0) return false;
//        int m = matrix.length;
//        int n =matrix[0].length;
//        int heigh = m - 1;
//        int low = 0;
//        int mid;
//        while (low <= heigh){
//            mid = (low + heigh)>>>1;
//            if (matrix[mid][0] == target)
//                return true;
//            if (matrix[mid][0]>target){
//                heigh = mid-1;
//            }else {
//                low = mid + 1;
//            }
//        }
//        int tem = heigh;
//        for (int i = 0; i <= tem; i++) {
//            low = 0;
//            heigh = n-1;
//            if (matrix[i][heigh] == target)
//                return true;
//            while (low < heigh){
//                mid = (low + heigh) >>> 1;
//                if (matrix[i][mid] == target)
//                    return true;
//                if (matrix[i][mid] < target){
//                    low = mid + 1;
//                }else {
//                    heigh = mid;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * 左下角开始向上与向右搜索。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null|| matrix.length == 0||matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int j = 0,i;
        for (i = m - 1; i >= 0; i--) {
            if (i < 0 || i >= m || j < 0|| j >= n)
                break;
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                continue;
            for (; j < n; j++) {
                if (matrix[i][j] == target)
                    return true;
                if (matrix[i][j] > target){
                    break;
                }
            }
        }
        return false;
    }
}

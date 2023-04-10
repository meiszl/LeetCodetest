package leetCodeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class 两数之和2 {
    public static int[] twoSum(int[] numbers, int target) {
        Set<Integer> resList = Arrays.stream(numbers).map(o -> target - o).boxed().collect(Collectors.toSet());
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            numberMap.put(numbers[i], i);
        }
        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (resList.contains(numbers[i])){
                res[0] = i + 1;
                if (Objects.equals(target - numbers[i], numbers[i])){
                    for (int i1 = i + 1; i1 < numbers.length; i1++) {
                        if (numberMap.containsKey(target - numbers[i])){
                            res[1] = numberMap.get(target - numbers[i]) + 1;
                            return res;
                        }
                    }
                }else {
                    for (int i1 = 0; i1 < numbers.length; i1++) {
                        if (numberMap.containsKey(target - numbers[i])){
                            res[1] = numberMap.get(target - numbers[i]) + 1;
                            return res;
                        }
                    }
                }

            }

        }
        return res;
    }

    /**
     * 最优解双指针算法
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

       int[] numbers = new int[30000];
        for (int i = 0; i < 30000; i++) {
            if (i == 29998 || i == 29999){
                numbers[i] = 1;
                continue;
            }
            numbers[i] = -1;
        }
        int target = 2;
        int[] res = twoSum(numbers, target);
        System.out.println(Arrays.toString(res));
    }
}

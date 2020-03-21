package leetCodeTest;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class 水壶问题 {
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        int z = 4;
        final boolean b = canMeasureWater(x, y, z);
        System.out.println("b = " + b);
    }

    /**
     * 预备知识：贝祖定理
     *
     * 我们认为，每次操作只会让桶里的水总量增加 x，增加 y，减少 x，或者减少 y。
     *
     * 你可能认为这有问题：如果往一个不满的桶里放水，或者把它排空呢？
     * 那变化量不就不是 x 或者 y 了吗？接下来我们来解释这一点：
     *
     * 首先要清楚，在题目所给的操作下，两个桶不可能同时有水且不满。因为观察所有题目中的操作，
     * 操作的结果都至少有一个桶是空的或者满的；
     *
     * 其次，对一个不满的桶加水是没有意义的。因为如果另一个桶是空的，
     * 那么这个操作的结果等价于直接从初始状态给这个桶加满水；而如果另一个桶是满的，
     * 那么这个操作的结果等价于从初始状态分别给两个桶加满；
     *
     * 再次，把一个不满的桶里面的水倒掉是没有意义的。因为如果另一个桶是空的，
     * 那么这个操作的结果等价于回到初始状态；而如果另一个桶是满的，
     * 那么这个操作的结果等价于从初始状态直接给另一个桶倒满。
     *
     * 因此，我们可以认为每次操作只会给水的总量带来 x 或者 y 的变化量。
     * 因此我们的目标可以改写成：找到一对整数 a,b使得
     *
     * ax+by=z
     *
     * 而只要满足 z≤x+y，且这样的 a,b 存在，那么我们的目标就是可以达成的。这是因为：
     *
     * 若 a≥0,b≥0，那么显然可以达成目标。
     *
     * 若 a<0，那么可以进行以下操作：
     *
     * 往 y 壶倒水；
     *
     * 把 y 壶的水倒入 x 壶；
     *
     * 如果 y 壶不为空，那么 x 壶肯定是满的，把 x 壶倒空，然后再把 y 壶的水倒入 x 壶。
     *
     * 重复以上操作直至某一步时 x 壶进行了 a 次倒空操作，y 壶进行了 b 次倒水操作。
     *
     * 若 b<0，方法同上，x 与 y 互换。
     *
     * 而贝祖定理告诉我们，ax+by=z 有解当且仅当 z 是 x,y 的最大公约数的倍数。
     * 因此我们只需要找到 x,y 的最大公约数并判断 z 是否是它的倍数即可。
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        if (x+y < z)
            return false;
        if (x==0||y==0)
            return z==0 || x+y==z;
        return z%gcd0(x,y)==0;
    }
    public static int gcd0(int a, int b) {
        if(a < 0 || b < 0)
            return -1;
        for (int i = a > b ? b : a; i > 1; i--) {
            if(a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }
    /**
     * 深度优先搜索
     * 思路及算法
     *
     * 首先对题目进行建模。观察题目可知，在任意一个时刻，此问题的状态可以由两个数字决定：
     * X 壶中的水量，以及 Y 壶中的水量。
     *
     * 在任意一个时刻，我们可以且仅可以采取以下几种操作：
     *
     * 把 X 壶的水灌进 Y 壶，直至灌满或倒空；
     * 把 Y 壶的水灌进 X 壶，直至灌满或倒空；
     * 把 X 壶灌满；
     * 把 Y 壶灌满；
     * 把 X 壶倒空；
     * 把 Y 壶倒空。
     * 因此，本题可以使用深度优先搜索来解决。搜索中的每一步以 remain_x, remain_y 作为状态，
     * 即表示 X 壶和 Y 壶中的水量。在每一步搜索时，我们会依次尝试所有的操作，递归地搜索下去。
     * 这可能会导致我们陷入无止境的递归，因此我们还需要使用一个哈希结合（HashSet）存储所有
     * 已经搜索过的 remain_x, remain_y 状态，保证每个状态至多只被搜索一次。
     *
     */
//    public static boolean canMeasureWater(int x, int y, int z) {
//       if (z == 0) {
//            return true;
//          }
//          if (x + y < z) {
//            return false;
//          }
//          Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
//          AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
//          queue.add(start);
//          Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
//          visited.add(start);
//          while (!queue.isEmpty()) {
//            Map.Entry<Integer, Integer> entry = queue.poll();
//            int curX = entry.getKey();
//            int curY = entry.getValue();
//            if (curX == z || curY == z || curX + curY == z) {
//              return true;
//            }
//            if (curX == 0) {
//              // 把第一个桶填满
//              addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, curY));
//            }
//            if (curY == 0) {
//              // 把第二个桶填满
//              addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, y));
//            }
//            if (curY < y) {
//              // 把第一个桶倒空
//              addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(0, curY));
//            }
//            if (curX < x) {
//              // 把第二个桶倒空
//              addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, 0));
//            }
//
//            // y - curY是第二个桶还可以再加的水的升数，但是最多只能加curX升水。
//            int moveSize = Math.min(curX, y - curY);
//            // 把第一个桶里的curX升水倒到第二个桶里去。
//            addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX - moveSize, curY + moveSize));
//            // 反过来同理，x - curX是第一个桶还可以再加的升数，但是最多只能加curY升水。
//            moveSize = Math.min(curY, x - curX);
//            // 把第一个桶里的curX升水倒到第二个桶里去。
//            addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX + moveSize, curY - moveSize));
//          }
//          return false;
//        }
//
//        private static void addIntoQueue(Queue<Map.Entry<Integer, Integer>> queue,
//                                         Set<Map.Entry<Integer, Integer>> visited,
//                                         Map.Entry<Integer, Integer> newEntry) {
//          if (!visited.contains(newEntry)) {
//            visited.add(newEntry);
//            queue.add(newEntry);
//          }
//        }

}

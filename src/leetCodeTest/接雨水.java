package leetCodeTest;


public class 接雨水 {
    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new 接雨水().trap(height);
        System.out.println("trap = " + trap);
    }

    /**
     * 思路：考虑存在两个长度变化的板，拦截住中间的小方块。
     * 板在两个位置:0,length-1.即最末尾与第一位。
     * 然后因为雨水会向低处流动，所以两个板长度不同那么中间的雨水一定会顺着较低的板流出一部分。
     * 那么剩下的被夹在中间的雨水体积就变成了较低板的长度（假设为l）减去当前的小方块高度（假设为k）。
     * 然后就得到了当前位置下能够存储水的体积，之后移动较低的板（左侧向右移，右侧向左移），
     * 并且由于移动了板，板的高度就变成了k（因为移动时能够挡住雨水的高度就变成了上一次小方块的高度，
     * 这里可以理解为板被小方块挡住了移不过去只能用小方块来当做下一次的挡雨水的板了）
     * 然后累加能够得到正数的l-k（因为如果小方块比较高的话雨水就会顺着前面的板流出去就没办法积攒雨水了）
     * 按照这个思路遍历所有板的可能即可获得最终的积雨量。
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0;//左指针
        int right = height.length-1;//右指针
        int ans = 0;//总积雨量
        int maxleft = 0;//左侧板的长度
        int maxright = 0;//右侧板的长度
        while (left <= right){//判断左指针是否大于右指针
            if (maxleft <= maxright){//判断左右两个板哪个小
                ans += maxleft - height[left] > 0 ?
                        maxleft - height[left] : 0;//判断板长减去当前小方块高度是否大于0（即l-k是否大于零，也就是说是否能够积累雨水）
                maxleft = Math.max(maxleft,height[left]);//更新板长
                left++;//左指针移动
            }else {//右指针操作一致
                ans += maxright - height[right] > 0 ?
                        maxright - height[right] : 0;
                maxright = Math.max(maxright,height[right]);
                right--;
            }
        }
        return ans;
    }
}

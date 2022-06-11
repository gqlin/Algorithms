package 贪心算法;

/**
 * @description：
 * @date： 2022/5/19 20:11
 * @author：gqlin
 */
public class CanJump {
/*    55. 跳跃游戏
    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

    数组中的每个元素代表你在该位置可以跳跃的最大长度。

    判断你是否能够到达最后一个下标。



    示例 1：

    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
    示例 2：

    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


    提示：

            1 <= nums.length <= 3 * 104
            0 <= nums[i] <= 105*/

/*    解题思路：
    思路
    刚看到本题一开始可能想：当前位置元素如果是3，我究竟是跳一步呢，还是两步呢，还是三步呢，究竟跳几步才是最优呢？

    其实跳几步无所谓，关键在于可跳的覆盖范围！

    不一定非要明确一次究竟跳几步，每次取最大的跳跃步数，这个就是可以跳跃的覆盖范围。

    这个范围内，别管是怎么跳的，反正一定可以跳过来。

    那么这个问题就转化为跳跃覆盖范围究竟可不可以覆盖到终点！

    每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。

    贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。*/

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            //coverRange = Math.max(coverRange, i + nums[i]);
            if ((i + nums[i]) > coverRange) {
                coverRange = i + nums[i];
            }
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

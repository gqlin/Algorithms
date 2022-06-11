package 贪心算法;

/**
 * @description：
 * @date： 2022/5/19 16:16
 * @author：gqlin
 */
public class MaxSubArray {
/*    53. 最大子数组和
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    子数组 是数组中的一个连续部分。



    示例 1：

    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    示例 2：

    输入：nums = [1]
    输出：1
    示例 3：

    输入：nums = [5,4,-1,7,8]
    输出：23


    提示：

            1 <= nums.length <= 105
            -104 <= nums[i] <= 104*/

    //解题步骤：https://www.programmercarl.com/0053.%E6%9C%80%E5%A4%A7%E5%AD%90%E5%BA%8F%E5%92%8C.html#%E6%9A%B4%E5%8A%9B%E8%A7%A3%E6%B3%95

    public int maxSubArray(int[] nums) {
        int result = -10001;//-10的四次方 <= nums[i] <= 10的四次方*/
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和；但是，同时不影响已经取得的result
            }
        }
        return result;
    }

}

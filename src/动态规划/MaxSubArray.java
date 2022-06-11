package 动态规划;

/**
 * @description：
 * @date： 2022/6/10 11:23
 * @author：gqlin
 */
public class MaxSubArray {

/*    3. 最大子序和
    力扣题目链接(opens new window)

    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    示例: 输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

            #思路
    这道题之前我们在讲解贪心专题的时候用贪心算法解决过一次，贪心算法：最大子序和 (opens new window)。

    这次我们用动态规划的思路再来分析一次。

    动规五部曲如下：

    1. 确定dp数组（dp table）以及下标的含义
    dp[i]：包括下标i之前的最大连续子序列和为dp[i]。

    2. 确定递推公式
    dp[i]只有两个方向可以推出来：

    dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
    nums[i]，即：从头开始计算当前连续子序列和
    一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);

    3. dp数组如何初始化
    从递推公式可以看出来dp[i]是依赖于dp[i - 1]的状态，dp[0]就是递推公式的基础。

    dp[0]应该是多少呢?

    根据dp[i]的定义，很明显dp[0]应为nums[0]即dp[0] = nums[0]。

    4. 确定遍历顺序
    递推公式中dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历。*/

    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];//包括下标i之前的最大连续子序列和为dp[i]
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /*
            dp[i]只有两个方向可以推出来：
            1. dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
            2. nums[i]，
               如果nums[i] > nums[i] + dp[i - 1],说明dp[i - 1]为负数，一个数与负数相加，结果只会越来越小
               即：要从nums[i]开始重新计算当前连续子序列和
            */
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);

            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }


}

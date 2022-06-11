package 动态规划.ZeroOneBag;

import org.junit.Test;

/**
 * @description：典型的01背包问题,dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
 * @date： 2022/5/27 12:44
 * @author：gqlin
 */
public class CanPartition {
/*    416. 分割等和子集
    给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



    示例 1：

    输入：nums = [1,5,11,5]
    输出：true
    解释：数组可以分割成 [1, 5, 5] 和 [11] 。
    示例 2：

    输入：nums = [1,2,3,5]
    输出：false
    解释：数组不能分割成两个元素和相等的子集。


    提示：

            1 <= nums.length <= 200
            1 <= nums[i] <= 100*/
    //解题思路：https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2.html#%E4%B8%80%E7%BB%B4dp%E6%95%B0%E7%BB%84-%E6%BB%9A%E5%8A%A8%E6%95%B0%E7%BB%84


    public boolean canPartition(int[] nums) {
        int half = 0;
        for (int i = 0; i < nums.length; i++) {
            half += nums[i];
        }
        if (half % 2 != 0) {
            return false;
        }
        half /= 2;
        int[] dp = new int[half + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[j] == half) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
//        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{8, 1, 2, 1}));
//        System.out.println(canPartition(new int[]{23, 13, 11, 7, 6, 5, 5}));
    }


}

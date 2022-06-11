package 动态规划;


import org.junit.Test;

import java.util.Arrays;

/**
 * @description：
 * @date： 2022/6/6 21:11
 * @author：gqlin
 */
public class LengthOfLIS {
/*    300. 最长递增子序列
    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

    子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。


    示例 1：

    输入：nums = [10,9,2,5,3,7,101,18]
    输出：4
    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
    示例 2：

    输入：nums = [0,1,0,3,2,3]
    输出：4
    示例 3：

    输入：nums = [7,7,7,7,7,7,7]
    输出：1


    提示：

            1 <= nums.length <= 2500
            -104 <= nums[i] <= 104*/

    //解题思路：https://programmercarl.com/0300.%E6%9C%80%E9%95%BF%E4%B8%8A%E5%8D%87%E5%AD%90%E5%BA%8F%E5%88%97.html#_300-%E6%9C%80%E9%95%BF%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];//dp[i]表示i之前包括i的以nums[i]结尾最长上升子序列的长度
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] > result) {
                    result = dp[i];
                }
            }

        }
        return result;
    }

    @Test
    public void test() {
//        lengthOfLIS(new int[]{10, 2, 7, 1, 2, 3, 4});
        lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});

    }

}

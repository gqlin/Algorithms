package 动态规划.ZeroOneBag;

/**
 * @description：在求装满背包有几种方法的情况下，递推公式一般为： dp[j] += dp[j - nums[i]];
 * @date： 2022/5/29 19:33
 * @author：gqlin
 */
public class FindTargetSumWays {
/*    494. 目标和
    给你一个整数数组 nums 和一个整数 target 。

    向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

    例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
    返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。



    示例 1：

    输入：nums = [1,1,1,1,1], target = 3
    输出：5
    解释：一共有 5 种方法让最终目标和为 3 。
            -1 + 1 + 1 + 1 + 1 = 3
            +1 - 1 + 1 + 1 + 1 = 3
            +1 + 1 - 1 + 1 + 1 = 3
            +1 + 1 + 1 - 1 + 1 = 3
            +1 + 1 + 1 + 1 - 1 = 3
    示例 2：

    输入：nums = [1], target = 1
    输出：1


    提示：

            1 <= nums.length <= 20
            0 <= nums[i] <= 1000
            0 <= sum(nums[i]) <= 1000
            -1000 <= target <= 1000*/

    //解题步骤：https://leetcode.cn/problems/target-sum/

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 != 0) {//因为都是整数，所以sum+target不能为基数
            return 0;
        }
        int left = sum + target > 0 ? sum + target : -(sum + target);//设left为全部加数的和，sum-left为全部减数的和left-（sum-left) = target;left = (sum+target)/2
        int[] dp = new int[left / 2 + 1];
        dp[0] = 1;//背包容量为0，什么也不选，也就是一种方法
        for (int i = 0; i < nums.length; i++) {
            for (int j = left / 2; j >= nums[i]; j--) {
                //公式含义：例如一共有五个数，算出总和为sum，根据sum和target算出背包容量最大为（sum+target)/2
                //例如示例一：背包容量最大为4，从nums[]中选数字，装满4有多少种选法。
                //          dp[j] 表示：填满j（包括j）这么大容积的包，有dp[j]种方法
                //          当j = 4，i= 0，，就相当于当前已经选了nums[0](也就是1），
                //          同时，《从剩下的nums元素中，任选三个，凑够4，有多少种选法》 相当于 dp[j - nums[0]] = dp[3]
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left / 2];
    }

}

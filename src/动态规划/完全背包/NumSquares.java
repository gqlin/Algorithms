package 动态规划.CompeleteBag;

import org.junit.Test;

/**
 * @description：
 * @date： 2022/6/1 15:45
 * @author：gqlin
 */
public class NumSquares {

/*    279. 完全平方数
    给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

    完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。



    示例 1：

    输入：n = 12
    输出：3
    解释：12 = 4 + 4 + 4
    示例 2：

    输入：n = 13
    输出：2
    解释：13 = 4 + 9

    提示：

            1 <= n <= 104*/

    //解题思路：https://programmercarl.com/0279.%E5%AE%8C%E5%85%A8%E5%B9%B3%E6%96%B9%E6%95%B0.html#%E6%80%9D%E8%B7%AF

    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化（当和为0时，组合的个数为0）
        for (int j = 1; j <= n; j++) {
            dp[j] = max;
        }
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        numSquares(13);
    }
}

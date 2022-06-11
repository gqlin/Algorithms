package 贪心算法;

/**
 * @description：
 * @date： 2022/5/19 16:51
 * @author：gqlin
 */
public class MaxProfit {


/*    122. 买卖股票的最佳时机 II
    给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

    在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

    返回 你能获得的 最大 利润 。



    示例 1：

    输入：prices = [7,1,5,3,6,4]
    输出：7
    解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
    总利润为 4 + 3 = 7 。
    示例 2：

    输入：prices = [1,2,3,4,5]
    输出：4
    解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
    总利润为 4 。
    示例 3：

    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。


    提示：

            1 <= prices.length <= 3 * 104
            0 <= prices[i] <= 104*/
    //解题步骤：https://www.programmercarl.com/0122.%E4%B9%B0%E5%8D%96%E8%82%A1%E7%A5%A8%E7%9A%84%E6%9C%80%E4%BD%B3%E6%97%B6%E6%9C%BAII.html#%E6%80%9D%E8%B7%AF
    //第一天是没有利润的，获得利润，起码是两天为一单位。
    //利用一个数组记录pro（长度为prices.length-1）相邻两天的利润
    //统计pro数组中的正数和，即为最大利润

    public int maxProfit(int[] prices) {

        if (prices.length == 1) {
            return 0;
        }
        int[] pro = new int[prices.length - 1];
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            pro[i - 1] = prices[i] - prices[i - 1];
        }
        for (int i = 0; i < pro.length; i++) {
            if (pro[i] > 0) {
                result += pro[i];
            }
        }
        return result;
    }
}

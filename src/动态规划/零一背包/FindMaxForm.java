package 动态规划.ZeroOneBag;

/**
 * @description：
 * @date： 2022/5/30 10:45
 * @author：gqlin
 */
public class FindMaxForm {
/*    474. 一和零
    给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

    请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

    如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。



    示例 1：

    输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
    输出：4
    解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
    其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
    示例 2：

    输入：strs = ["10", "0", "1"], m = 1, n = 1
    输出：2
    解释：最大的子集是 {"0", "1"} ，所以答案是 2 。


    提示：

            1 <= strs.length <= 600
            1 <= strs[i].length <= 100
    strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100*/

/*  解题步骤：
    多重背包是每个物品，数量不同的情况。

    本题中strs 数组里的元素就是物品，每个物品都是一个！

    而m 和 n相当于是一个背包，两个维度的背包。

    理解成多重背包的同学主要是把m和n混淆为物品了，感觉这是不同数量的物品，所以以为是多重背包。

    但本题其实是01背包问题！

    这不过这个背包有两个维度，一个是m 一个是n，而不同长度的字符串就是不同大小的待装物品。

    开始动规五部曲：

    1.确定dp数组（dp table）以及下标的含义
      dp[i][j]：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。

    2. 确定递推公式
      dp[i][j] 可以由前一个strs里的字符串推导出来，strs里的字符串有zeroNum个0，oneNum个1。

    dp[i][j] 就可以是 dp[i - zeroNum][j - oneNum] + 1。

    然后我们在遍历的过程中，取dp[i][j]的最大值。

    所以递推公式：dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);

    此时大家可以回想一下01背包的递推公式：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);

    对比一下就会发现，字符串的zeroNum和oneNum相当于物品的重量（weight[i]），字符串本身的个数相当于物品的价值（value[i]）。

    这就是一个典型的01背包！ 只不过物品的重量有了两个维度而已。

    3. dp数组如何初始化
       在动态规划：关于01背包问题，你该了解这些！（滚动数组） (opens new window)中已经讲解了，01背包的dp数组初始化为0就可以。

    因为物品价值不会是负数，初始为0，保证递推的时候dp[i][j]不会被初始值覆盖。

    4. 确定遍历顺序
       在动态规划：关于01背包问题，你该了解这些！（滚动数组） (opens new window)中，我们讲到了01背包为什么一定是外层for循环遍历物品，内层for循环遍历背包容量且从后向前遍历！

    那么本题也是，物品就是strs里的字符串，背包容量就是题目描述中的m和n。*/

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < strs.length; i++) {
            zeroCount = 0;
            oneCount = 0;

            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            for (int k = m; k >= zeroCount; k--) {
                for (int l = n; l >= oneCount; l--) {
                    dp[k][l] = Math.max(dp[k][l], dp[k - zeroCount][l - oneCount] + 1);
                }
            }

        }
        return dp[m][n];
    }
}

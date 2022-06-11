package 动态规划;

/**
 * @description：
 * @date： 2022/5/24 21:55
 * @author：gqlin
 */
public class UniquePaths {
/*    62. 不同路径
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

    问总共有多少条不同的路径？



    示例 1：


    输入：m = 3, n = 7
    输出：28
    示例 2：

    输入：m = 3, n = 2
    输出：3
    解释：
    从左上角开始，总共有 3 条路径可以到达右下角。
            1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
    示例 3：

    输入：m = 7, n = 3
    输出：28
    示例 4：

    输入：m = 3, n = 3
    输出：6*/

    //解题关键：dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {//只有一行或者只有一列，只有一条路径
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {//[1,1],[2,1],[3,1]等等都是一条路径
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {//[1,1],[1,2],[1,3]等等都是一条路径
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

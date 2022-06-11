package 动态规划;

import java.util.LinkedList;

/**
 * @description：
 * @date： 2022/5/24 22:46
 * @author：gqlin
 */
public class IntegerBreak {
/*    343. 整数拆分
    给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

    返回 你可以获得的最大乘积 。



    示例 1:

    输入: n = 2
    输出: 1
    解释: 2 = 1 + 1, 1 × 1 = 1。
    示例 2:

    输入: n = 10
    输出: 36
    解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。


    提示:

            2 <= n <= 58*/

    //解题思路：当n>=7,结果都等于3*（当n等于n-3时候的结果）
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        if (n == 5) return 6;
        if (n == 6) return 9;
        LinkedList<Integer> dp = new LinkedList<>();
        dp.add(4);
        dp.add(6);
        dp.add(9);
        for (int i = 7; i <= n; i++) {
            int temp = 3 * dp.pop();
            dp.add(temp);
        }
        return dp.getLast();
    }
}

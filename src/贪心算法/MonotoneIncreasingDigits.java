package 贪心算法;

/**
 * @description：
 * @date： 2022/5/22 20:19
 * @author：gqlin
 */
public class MonotoneIncreasingDigits {
/*    738. 单调递增的数字
    当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。

    给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。



    示例 1:

    输入: n = 10
    输出: 9
    示例 2:

    输入: n = 1234
    输出: 1234
    示例 3:

    输入: n = 332
    输出: 299


    提示:

            0 <= n <= 109*/

/*    解题思路：
    贪心算法
    题目要求小于等于N的最大单调递增的整数，那么拿一个两位的数字来举例。

    例如：98，一旦出现strNum[i - 1] > strNum[i]的情况（非单调递增），首先想让strNum[i - 1]--，然后strNum[i]给为9，这样这个整数就是89，即小于98的最大的单调递增整数。

    这一点如果想清楚了，这道题就好办了。

    局部最优：遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]--，然后strNum[i]给为9，可以保证这两位变成最大单调递增整数。

    全局最优：得到小于等于N的最大单调递增的整数。

    但这里局部最优推出全局最优，还需要其他条件，即遍历顺序，和标记从哪一位开始统一改成9。

    此时是从前向后遍历还是从后向前遍历呢？

    从前向后遍历的话，遇到strNum[i - 1] > strNum[i]的情况，让strNum[i - 1]减一，但此时如果strNum[i - 1]减一了，可能又小于strNum[i - 2]。

    这么说有点抽象，举个例子，数字：332，从前向后遍历的话，那么就把变成了329，此时2又小于了第一位的3了，真正的结果应该是299。

    所以从前后向遍历会改变已经遍历过的结果！

    那么从后向前遍历，就可以重复利用上次比较得出的结果了，从后向前遍历332的数值变化为：332 -> 329 -> 299

    确定了遍历顺序之后，那么此时局部最优就可以推出全局，找不出反例，试试贪心。*/


    public int monotoneIncreasingDigits(int n) {
        char[] res = Integer.toString(n).toCharArray();
        int firstNine = res.length;
        int start = res.length;
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] < res[i - 1]) {
                res[i - 1] = (char) (res[i - 1] - 1);
                start = i;
            }
        }
        for (int i = start; i < res.length; i++) {
            res[i] = '9';
        }

        return Integer.parseInt(String.valueOf(res));
    }

}

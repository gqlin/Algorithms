package 动态规划.最长重复数组问题;

/**
 * @description：
 * @date： 2022/6/8 20:49
 * @author：gqlin
 */
public class LongestCommonSubsequence {

/*    1143.最长公共子序列
    力扣题目链接(opens new window)

    给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

    若这两个字符串没有公共子序列，则返回 0。

    示例 1:

    输入：text1 = "abcde", text2 = "ace"
    输出：3
    解释：最长公共子序列是 "ace"，它的长度为 3。

    示例 2:
    输入：text1 = "abc", text2 = "abc"
    输出：3
    解释：最长公共子序列是 "abc"，它的长度为 3。

    示例 3:
    输入：text1 = "abc", text2 = "def"
    输出：0
    解释：两个字符串没有公共子序列，返回 0。

    提示:

            1 <= text1.length <= 1000
            1 <= text2.length <= 1000 输入的字符串只含有小写英文字符。*/


/*    思路：
    本题和动态规划：718. 最长重复子数组 (opens new window)区别在于这里不要求是连续的了，
    但要有相对顺序，即："ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    https://www.programmercarl.com/1143.%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97.html#_1143-%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97*/

    public int longestCommonSubsequence(String text1, String text2) {

        //长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                //与《718. 最长重复子数组 》不同的是，本题不要求连续，所以要加上这一个步骤
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}

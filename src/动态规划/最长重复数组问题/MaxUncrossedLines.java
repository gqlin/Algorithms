package 动态规划.最长重复数组问题;

/**
 * @description：
 * @date： 2022/6/8 21:45
 * @author：gqlin
 */
public class MaxUncrossedLines {
//    题目：https://leetcode.cn/problems/uncrossed-lines/

    //解题思路：https://www.programmercarl.com/1035.%E4%B8%8D%E7%9B%B8%E4%BA%A4%E7%9A%84%E7%BA%BF.html#_1035-%E4%B8%8D%E7%9B%B8%E4%BA%A4%E7%9A%84%E7%BA%BF
    //其实本题代码逻辑与《1143.最长公共子序列》一摸一样，只需要将1143中字符串长度改为本题中的数组长度就行

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}

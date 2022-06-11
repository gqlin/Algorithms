package 贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @date： 2022/5/22 11:17
 * @author：gqlin
 */
public class PartitionLabels {
/*    763. 划分字母区间
    字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。



    示例：

    输入：S = "ababcbacadefegdehijhklij"
    输出：[9,7,8]
    解释：
    划分结果为 "ababcbaca", "defegde", "hijhklij"。
    每个字母最多出现在一个片段中。
    像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。


    提示：

    S的长度在[1, 500]之间。
    S只包含小写字母 'a' 到 'z' 。*/

/*    解题思路：
    一想到分割字符串就想到了回溯，但本题其实不用回溯去暴力搜索。

    题目要求同一字母最多出现在一个片段中，那么如何把同一个字母的都圈在同一个区间里呢？

    如果没有接触过这种题目的话，还挺有难度的。

    在遍历的过程中相当于是要找每一个字母的边界，如果找到之前遍历过的所有字母的最远边界，说明这个边界就是分割点了。此时前面出现过所有字母，最远也就到这个边界了。

    可以分为如下两步：

    统计每一个字符最后出现的位置
    从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点*/

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] edge = new int[26];//edge记录某个字母在字符串中的最远位置
        for (int i = 0; i < s.length(); i++) {
            edge[s.charAt(i) - 'a'] = i;//edge记录char[i]在字符串中的最远位置
        }
        int end = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(edge[s.charAt(i) - 'a'], end);//不断更新
            if (i == end) {
                res.add(i + 1 - last);
                end = 0;
                last = i + 1;
            }
        }
        return res;
    }
}

package 动态规划.CompeleteBag;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @description： 但本题还有特殊性，因为是要求子串，最好是遍历背包放在外循环，将遍历物品放在内循环。
 * <p>
 * 如果要是外层for循环遍历物品，内层for遍历背包，就需要把所有的子串都预先放在一个容器里。（如果不理解的话，可以自己尝试这么写一写就理解了）
 * <p>
 * 所以最终我选择的遍历顺序为：遍历背包放在外循环，将遍历物品放在内循环。内循环从前到后。
 * @date： 2022/6/1 16:10
 * @author：gqlin
 */
public class WordBreak {
/*    139. 单词拆分
    给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

    注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。



    示例 1：

    输入: s = "leetcode", wordDict = ["leet", "code"]
    输出: true
    解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
    示例 2：

    输入: s = "applepenapple", wordDict = ["apple", "pen"]
    输出: true
    解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
    注意，你可以重复使用字典中的单词。
    示例 3：

    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]*/

    //解题思路：https://programmercarl.com/0139.%E5%8D%95%E8%AF%8D%E6%8B%86%E5%88%86.html#_139-%E5%8D%95%E8%AF%8D%E6%8B%86%E5%88%86

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                /*如果果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。

                所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。*/
                if (wordDict.contains(s.substring(j, i)) && dp[j] == true) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }


    @Test
    public void test() {
        wordBreak("leetcode", Arrays.asList("leet", "code"));
        wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));

    }
}

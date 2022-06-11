package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：分隔问题
 * @date： 2022/5/14 14:45
 * @author：gqlin
 */
public class Partition {
    /*    131. 分割回文串
        给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

        回文串 是正着读和反着读都一样的字符串。

        示例 1：
        输入：s = "aab"
        输出：[["a","a","b"],["aa","b"]]

        示例 2：
        输入：s = "a"
        输出：[["a"]]

        提示：
                1 <= s.length <= 16
        s 仅由小写英文字母组成*/

    List<List<String>> result = new ArrayList<>();
    ArrayList path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0, s.length());
        return result;
    }

    // 在本例中，
    // for负责横向遍历（截取a、aa、aab，然后由递归处理a后面的内容、aa后面的内容，aab后面的内容（当然，aab后面没有字符了））；
    // 递归负责纵向遍历（处理a后面的内容、aa后面的内容，aab后面的内容（当然，aab后面没有字符了））
    public void backtracking(String s, int startIndex, int length) {
        if (startIndex == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < length; i++) {
            String temp = s.substring(startIndex, i + 1);
            if (isPalindrome(temp)) {
                path.add(temp);
            }
            //如果temp不是回文串，扩大temp的长度
            else {
                continue;//跳过下面两条语句，执行i++,执行s.substring(startIndex, i + 1)，相当于简介扩大了temp的长度
            }
            //如果temp是回文串，递归处理temp后面的内容，startIndex变成i+1
            backtracking(s, i + 1, length);
            path.remove(path.size() - 1);
        }
    }


    public boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void test() {
        partition("aab");
    }
}

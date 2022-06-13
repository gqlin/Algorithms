/*
647. 回文子串
        给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

        回文字符串 是正着读和倒过来读一样的字符串。

        子字符串 是字符串中的由连续字符组成的一个序列。

        具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。



        示例 1：

        输入：s = "abc"
        输出：3
        解释：三个回文子串: "a", "b", "c"
        示例 2：

        输入：s = "aaa"
        输出：6
        解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"


        提示：

        1 <= s.length <= 1000
        s 由小写英文字母组成*/

/*
解题关键：
双指针法
动态规划的空间复杂度是偏高的，我们再看一下双指针法。

首先确定回文串，就是找中心然后向两边扩散看是不是对称的就可以了。

在遍历中心点的时候，要注意中心点有两种情况。

一个元素可以作为中心点，两个元素也可以作为中心点。

那么有人同学问了，三个元素还可以做中心点呢。其实三个元素就可以由一个元素左右添加元素得到，四个元素则可以由两个元素左右添加元素得到。

所以我们在计算的时候，要注意一个元素为中心点和两个元素为中心点的情况。
*/

public class CountSubstrings {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += rev(s, i, i);
            result += rev(s, i, i + 1);
        }
        return result;
    }

    int rev(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }
        return result;
    }
}

package 字符串相关问题;

import org.junit.Test;

/**
 * @description：kmp算法
 * @date： 2022/4/26 20:04
 * @author：gqlin
 */
public class StrStr {
/*
    28. 实现 strStr()
    实现 strStr() 函数。

    给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。



    说明：

    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。



    示例 1：
    输入：haystack = "hello", needle = "ll"
    输出：2

    示例 2：
    输入：haystack = "aaaaa", needle = "bba"
    输出：-1

    示例 3：
    输入：haystack = "", needle = ""
    输出：0*/

    //解题步骤：https://www.programmercarl.com/0028.%E5%AE%9E%E7%8E%B0strStr.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC


    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    //获取next数组
    //next数组：next[i] 存放【当前长度为i的字串】的【最长相等前后缀】的【长度】
    //         也相当于，存放【最长相等前后缀】的【前缀的最后一位】的【下标】
    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }

    @Test
    public void test() {
        strStr("ababa", "aabaaac");

    }

}

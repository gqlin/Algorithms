package 字符串相关问题;

import org.junit.Test;

/**
 * @description：
 * @date： 2022/4/26 12:39
 * @author：gqlin
 */
public class ReverseWords {
/*    151. 颠倒字符串中的单词
    给你一个字符串 s ，颠倒字符串中 单词 的顺序。

    单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

    返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

    注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。



    示例 1：

    输入：s = "the sky is blue"
    输出："blue is sky the"
    示例 2：

    输入：s = "  hello world  "
    输出："world hello"
    解释：颠倒后的字符串中不能存在前导空格和尾随空格。
    示例 3：

    输入：s = "a good   example"
    输出："example good a"
    解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。*/

/*
   想一下，我们将整个字符串都反转过来，那么单词的顺序指定是倒序了，只不过单词本身也倒序了，那么再把单词反转一下，单词不就正过来了。

    所以解题思路如下：

    移除多余空格
            将整个字符串反转
    将每个单词反转
    举个例子，源字符串为："the sky is blue "

    移除多余空格 : "the sky is blue"
    字符串反转："eulb si yks eht"
    单词反转："blue is sky the"
    这样我们就完成了翻转字符串里的单词。*/

    public String reverseWords(String s) {
        int length = s.length();
        if (s == null) {
            return null;
        }
        StringBuffer temp = new StringBuffer(s).reverse();
        StringBuffer result = new StringBuffer();
        int left = 0;
        int right = 0;
        while (right < length) {
            if (temp.charAt(right) == ' ') {
                left++;
                right++;
            } else {
                while (temp.charAt(right) != ' ') {
                    right++;
                    if (right >= length) {
                        break;
                    }
                }
                String substring = temp.substring(left, right);
                result.append(reverseStr(substring) + ' ');
                left = right;
            }
        }
        return result.substring(0, result.length() - 1);
    }


    public String reverseStr(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

}

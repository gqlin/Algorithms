package 字符串相关问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：字符串比较不能用“==”，要用equals()方法;利用数组进行字符串、数字的映射
 * @date： 2022/5/12 23:55
 * @author：gqlin
 */

public class LetterCombinations {

/*    17. 电话号码的字母组合
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

    数字到字母的映射与九宫格输入法按键相同。注意 1 不对应任何字母。

    示例 1：

    输入：digits = "23"
    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    示例 2：

    输入：digits = ""
    输出：[]
    示例 3：

    输入：digits = "2"
    输出：["a","b","c"]

    提示：

    0 <= digits.length <= 4
    digits[i] 是范围 ['2', '9'] 的一个数字。*/

    //解题步骤：https://www.programmercarl.com/0017.%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88.html#java

    List<String> result = new ArrayList<>();
    String[] charMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder temp = new StringBuilder(4);


    public List<String> letterCombinations(String digits) {
        //提示说明了digtis可能为""
        //不能用digits == "" 来判断，字符串的比较要用equals()方法
        if (digits == null || digits.length() == 0) {
            return result;
        }
        combine(digits.length(), digits, 0);
        return result;
    }

    public void combine(int length, String digits, int num) {
        if (temp.length() == length) {//不要管num有没有超出digits 的长度，因为本题中temp.length到了终点，num超了也会被丢弃
            result.add(temp.toString());
            return;
        }

        String s = charMap[digits.charAt(num) - '0'];
        for (int i = 0; i < s.length(); i++) {
            temp.append(s.charAt(i));
            combine(length, digits, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

}

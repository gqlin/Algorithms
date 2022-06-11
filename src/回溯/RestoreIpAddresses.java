package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:切割问题
 * @date： 2022/5/16 10:38
 * @author：gqlin
 */
public class RestoreIpAddresses {

/*    93. 复原 IP 地址
    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

    例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
    给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。



    示例 1：

    输入：s = "25525511135"
    输出：["255.255.11.135","255.255.111.35"]
    示例 2：

    输入：s = "0000"
    输出：["0.0.0.0"]
    示例 3：

    输入：s = "101023"
    输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


    提示：

            1 <= s.length <= 20
    s 仅由数字组成*/

    //解题步骤：https://www.programmercarl.com/0093.%E5%A4%8D%E5%8E%9FIP%E5%9C%B0%E5%9D%80.html#java

    List<String> result = new ArrayList<String>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        restoreIpAddressesHandler(s, 0, 0);
        return result;
    }

    // count表示stringbuilder中ip段的数量
    public void restoreIpAddressesHandler(String s, int start, int count) {
        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && count == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
        if (start == s.length() || count == 4) {
            return;
        }

        // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
        for (int i = start; i < s.length() && i - start < 3 && Integer.parseInt(s.substring(start, i + 1)) >= 0
                && Integer.parseInt(s.substring(start, i + 1)) <= 255; i++) {
            // 如果ip段的长度大于1，并且第一位为0的话，continue
            if (i + 1 - start > 1 && s.charAt(start) == '0') {
                continue;
            }
            stringBuilder.append(s, start, i + 1);
            // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
            if (count < 3) {
                stringBuilder.append(".");
            }
            restoreIpAddressesHandler(s, i + 1, count + 1);
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            stringBuilder.delete(start + count, i + count + 2);//count的数量等于逗点的数量，但是start是用于源字符串的，所以在操作删除ip串的时候要加上count
        }
    }


    @Test
    public void test() {
        restoreIpAddressesHandler("25525511135", 0, 0);
    }
}

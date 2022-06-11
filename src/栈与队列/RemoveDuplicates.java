package 栈与队列;

import java.util.Stack;

/**
 * @description：
 * @date： 2022/4/27 16:48
 * @author：gqlin
 */
public class RemoveDuplicates {
/*    1047. 删除字符串中的所有相邻重复项
    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

    在 S 上反复执行重复项删除操作，直到无法继续删除。

    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。



    示例：

    输入："abbaca"
    输出："ca"
    解释：
    例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。*/

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length() - 1;
        while (length >= 0) {
            char temp = s.charAt(length--);
            if (stack.empty()) {
                stack.push(temp);
            } else {
                if (stack.peek() == temp) {
                    stack.pop();
                } else {
                    stack.push(temp);
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.empty()) {
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.toString();
    }
}

package 双指针;

/**
 * @description：
 * @date： 2022/4/17 19:53
 * @author：gqlin
 */
public class IsHappy {
/*    202. 快乐数
    编写一个算法来判断一个数 n 是不是快乐数。

            「快乐数」 定义为：

    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
    如果这个过程 结果为 1，那么这个数就是快乐数。
    如果 n 是 快乐数 就返回 true ；不是，则返回 false 。



    示例 1：

    输入：n = 19
    输出：true
    解释：
            12 + 92 = 82
            82 + 22 = 68
            62 + 82 = 100
            12 + 02 + 02 = 1
    示例 2：

    输入：n = 2
    输出：false*/

    //解题思路：
    //参考英文网站热评第一。这题可以用快慢指针的思想去做，有点类似于检测是否为环形链表那道题
    //如果给定的数字最后会一直循环重复，那么快的指针（值）一定会追上慢的指针（值），也就是
    //两者一定会相等。如果没有循环重复，那么最后快慢指针也会相等，且都等于1。

//    为什么不快乐的数最后快的指针会追上慢的指针?
//    你和女朋友在操场散步，你走1m，她走2m，相当于你每次原地不动，她走1m，那她是不是一定会走到你的位置。

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = nextNum(slow);
            fast = nextNum(fast);
            fast = nextNum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    public int nextNum(int num) {
        int sum = 0;
        while (num > 0) {
            int bit = num % 10;
            sum += bit * bit;
            num = num / 10;
        }
        return sum;
    }


}

package 字符串相关问题;

/**
 * @description：
 * @date： 2022/4/16 20:31
 * @author：gqlin
 */
public class IsAnagram {
/*
    242. 有效的字母异位词
    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

    注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。



    示例1:

    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:

    输入: s = "rat", t = "car"
    输出: false


    提示:

            1 <= s.length, t.length <= 5 * 104
    s 和 t仅包含小写字母*/


//    解题思路：
//    定义一个数组叫做record用来上记录字符串s里字符出现的次数。
//
//    需要把字符映射到数组也就是哈希表的索引下标上，因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下标0，相应的字符z映射为下标25。
//
//    再遍历 字符串s的时候，只需要将 s[i] - ‘a’ 所在的元素做+1 操作即可，并不需要记住字符a的ASCII，只要求出一个相对数值就可以了。 这样就将字符串s中字符出现的次数，统计出来了。
//
//    那看一下如何检查字符串t中是否出现了这些字符，同样在遍历字符串t的时候，对t中出现的字符映射哈希表索引上的数值再做-1的操作。
//
//    那么最后检查一下，record数组如果有的元素不为零0，说明字符串s和t一定是谁多了字符或者谁少了字符，return false。
//
//    最后如果record数组所有元素都为零0，说明字符串s和t是字母异位词，return true。
//
//    时间复杂度为O(n)，空间上因为定义是的一个常量大小的辅助数组，所以空间复杂度为O(1)。

    public boolean isAnagram(String s, String t) {
        int record[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

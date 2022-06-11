package 双指针;

import org.junit.Test;

/**
 * @description：滑动窗口
 * @date： 2022/4/17 22:13
 * @author：gqlin
 */
public class MinSubArrayLen {
    /*
    209. 长度最小的子数组
    给定一个含有 n 个正整数的数组和一个正整数 target 。

    找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



    示例 1：

    输入：target = 7, nums = [2,3,1,2,4,3]
    输出：2
    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
    示例 2：

    输入：target = 4, nums = [1,4,4]
    输出：1
    示例 3：

    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
    输出：0*/

    //解题步骤：https://www.programmercarl.com/0209.%E9%95%BF%E5%BA%A6%E6%9C%80%E5%B0%8F%E7%9A%84%E5%AD%90%E6%95%B0%E7%BB%84.html#%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3

    public int minSubArrayLen(int target, int[] nums) {
        //result用来存放上一次最短长度
        int result = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //左右指针区间内的值相加
            sum += nums[right];
            //当区间内的值大于目标值
            while (sum >= target) {
                //得到当前区间长度
                int subLength = right - left + 1;
                //判断当前上一次最短长度与当前最短长度，要排除第一次判断的时候result=0造成的错误
                result = result == 0 || result > subLength ? subLength : result;
                //无论最短长度如何变化，左指针向后移动，区间缩小
                sum -= nums[left++];
            }
            right++;
        }

        return result;
    }

    @Test
    public void testminSubArrayLen() {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}

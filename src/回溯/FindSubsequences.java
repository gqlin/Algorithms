package 回溯;

import org.junit.Test;

import java.util.*;

/**
 * @description：子集问题--相同父节点下的去重问题
 * @date： 2022/5/16 20:03
 * @author：gqlin
 */
public class FindSubsequences {
/*    491. 递增子序列
    给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。

    数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。



    示例 1：

    输入：nums = [4,6,7,7]
    输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
    示例 2：

    输入：nums = [4,4,3,2,1]
    输出：[[4,4]]


    提示：

            1 <= nums.length <= 15
            -100 <= nums[i] <= 100*/

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int start) {
        HashSet<Integer> appear = new HashSet<>();
        for (int i = start; i < nums.length; i++) {

            if (appear.contains(nums[i]) || (path.size() > 0 && nums[i] < path.getLast())) {
                continue;//同一层for循环中，出现过的元素抛弃
            } else {
                appear.add(nums[i]);
                path.add(nums[i]);
            }
            if (path.size() > 1) {
                res.add(new ArrayList<>(path));
            }
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        findSubsequences(new int[]{1, 3, 1, 1});
    }
}

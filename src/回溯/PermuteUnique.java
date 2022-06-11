package 回溯;

import java.util.*;

/**
 * @description：全排列（去重问题）
 * @date： 2022/5/17 15:06
 * @author：gqlin
 */
public class PermuteUnique {

/*    47. 全排列 II
    给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



    示例 1：

    输入：nums = [1,1,2]
    输出：
            [[1,1,2],
            [1,2,1],
            [2,1,1]]
    示例 2：

    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


    提示：

            1 <= nums.length <= 8
            -10 <= nums[i] <= 10*/

    //解题步骤：https://www.programmercarl.com/0047.%E5%85%A8%E6%8E%92%E5%88%97II.html#_47-%E5%85%A8%E6%8E%92%E5%88%97-ii

/*
    方法一：自己写的
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] flag = new int[nums.length];
        backtracking(nums, flag);
        return res;
    }

    public void backtracking(int[] nums, int[] flag) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> appear = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 0 && !appear.contains(nums[i])) {//如果flag[i] == 0,说明上层递归中还没使用该元素
                path.add(nums[i]);
                flag[i] = 1;//对应的flag[]需要被标记为1
                appear.add(nums[i]);
            } else {
                continue;//如果flag[i] == 1,说明上层递归中已经使用过了该元素，跳过该元素，本层递归中的for循环中继续
            }
            backtracking(nums, flag);
            flag[i] = 0;//回溯，对应的flag[]需要被标记为0
            path.removeLast();//回溯，path移除最后一个元素
        }
    }*/

    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);//boolean数组默认全为true
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 在i>0的情况下：
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过 （树枝，可以理解为同一条递归线）
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过（树层，可以理解为一个for循环内）
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backTrack(nums, used);
                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }

}

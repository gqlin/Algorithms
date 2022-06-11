package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description：全排列问题--利用等长数组记录元素是否被使用过
 * @date： 2022/5/17 14:32
 * @author：gqlin
 */
public class Permute {

/*    46. 全排列
    给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。



    示例 1：

    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    示例 2：

    输入：nums = [0,1]
    输出：[[0,1],[1,0]]
    示例 3：

    输入：nums = [1]
    输出：[[1]]


    提示：

            1 <= nums.length <= 6
            -10 <= nums[i] <= 10
    nums 中的所有整数 互不相同*/

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int[] flag = new int[nums.length];
        backtracking(nums, flag);
        return res;
    }

    public void backtracking(int[] nums, int[] flag) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 0) {//如果flag[i] == 0,说明上层递归中还没使用该元素
                path.add(nums[i]);
                flag[i] = 1;//对应的flag[]需要被标记为1
            } else {
                continue;//如果flag[i] == 1,说明上层递归中已经使用过了该元素，跳过该元素，本层递归中的for循环中继续
            }
            backtracking(nums, flag);
            flag[i] = 0;//回溯，对应的flag[]需要被标记为0
            path.removeLast();//回溯，path移除最后一个元素
        }
    }

    @Test
    public void test() {
        permute(new int[]{1, 2, 3});
    }
}

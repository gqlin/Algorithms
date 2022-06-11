package 双指针;


import java.util.*;

/**
 * @description：
 * @date： 2022/4/25 15:18
 * @author：gqlin
 */
public class ThreeSum {
/*
    15. 三数之和
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

    注意：答案中不可以包含重复的三元组。



    示例 1：

    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]
    示例 2：

    输入：nums = []
    输出：[]
    示例 3：

    输入：nums = [0]
    输出：[]*/


//    解题步骤：
//    拿这个nums数组来举例，首先将数组排序，然后有一层for循环，i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。
//
//    依然还是在数组中找到 abc 使得a + b +c =0，我们这里相当于 a = nums[i] b = nums[left] c = nums[right]。
//
//    接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
//
//    如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= length - 3; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int temp = nums[i] + nums[right] + nums[left];
                if (temp > 0) {
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    set.add(integers);
                    right--;
                    left++;
                }
            }
        }
        for (List<Integer> integerList : set) {
            list.add(integerList);
        }
        return list;
    }

}

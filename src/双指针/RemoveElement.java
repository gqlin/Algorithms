package 双指针;

import org.junit.Test;

public class RemoveElement {


    /*
        27.移除元素
        给你c个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。

        不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

        元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。



        说明:

        为什么返回数值是整数，但输出的答案是数组呢?

        请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

        你可以想象内部操作如下:

        // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
        int len = removeElement(nums, val);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }


        示例 1：

        输入：nums = [3,2,2,3], val = 3
        输出：2, nums = [2,2]
        解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
        示例 2：

        输入：nums = [0,1,2,2,3,0,4,2], val = 2
        输出：5, nums = [0,1,4,0,3]
        解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

    */

    //解题思路：https://www.programmercarl.com/0027.%E7%A7%BB%E9%99%A4%E5%85%83%E7%B4%A0.html#%E6%80%9D%E8%B7%AF
    //精妙之处：如果fastPointer指向的值不等于目标值，slow会先于fast移动
    public int removeElement(int[] nums, int val) {

        int fastPointer = 0;
        int slowPointer = 0;
        int length = nums.length;
        while (fastPointer < length) {
            // 如果fastPointer指向的值，不等于目标值；slowPointer紧跟着追赶；如果是第一个值就不等于目标值，slowPointer会领先一位
            if (nums[fastPointer] != val) {
                //slowPointer指向的值被覆盖为当前fastPointer指向的值
                nums[slowPointer] = nums[fastPointer];
                //slowPointer向后移动一位
                slowPointer++;
            }

            // 无论什么情况，fastPointer向后移动一位
            //但是如果上面nums[fastPointer] != val成立，相当于slow不动，fast跳过重复项，开始领先
            fastPointer++;
        }
        return slowPointer;
    }

    @Test
    public void testRemoveElement() {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }


}

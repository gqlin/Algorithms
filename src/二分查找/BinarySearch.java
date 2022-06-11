package 二分查找;


import org.junit.Test;

/**
 * @description：二分查找 思想：折半地缩小查找区间
 * @date： 2022/4/4 17:12
 * @author：gqlin
 */
public class BinarySearch {


    @Test
    public void test() {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 7));
    }


    /*
        704. 二分查找

        给定一个n个元素有序的（升序）整型数组nums 和一个目标值target，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。


        示例 1:
        输入: nums = [-1,0,3,5,9,12], target = 9
        输出: 4
        解释: 9 出现在 nums 中并且下标为 4

        示例2:
        输入: nums = [-1,0,3,5,9,12], target = 2
        输出: -1
        解释: 2 不存在 nums 中因此返回 -1
    */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            //确定mid的指向位置
            mid = (low + high) / 2;
            //如果mid指向的跟目标值相等，说明找到了
            if (nums[mid] == target) {
                return mid;
            }
            //如果mid指向的值比目标值小，low指向的位置移动到中间值的后一位
            if (target > nums[mid]) {
                low = mid + 1;
            }
            //如果mid指向的值比目标值大，high指向的位置移动到中间值的前一位
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

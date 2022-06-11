package 栈与队列;

import java.util.LinkedList;

/**
 * @description：单调队列
 * @date： 2022/4/27 20:15
 * @author：gqlin
 */
public class MaxSlidingWindow {
/*    239. 滑动窗口最大值
    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

    返回 滑动窗口中的最大值 。



    示例 1：

    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    输出：[3,3,5,5,6,7]
    解释：
    滑动窗口的位置                最大值
---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7

    示例 2：
    输入：nums = [1], k = 1
    输出：[1]*/

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyDegreeQueue myDegreeQueue = new MyDegreeQueue();
        int length = nums.length;
        int[] res = new int[length - k + 1];//自己验证返回结果的长度
        int index = k;
        //第一个窗口，保证第一个窗口的最大值在第一个位置
        for (int i = 0; i < k; i++) {
            myDegreeQueue.push(nums[i]);
            res[0] = myDegreeQueue.peekFirst();
        }
        while (index < length) {
            //当窗口移动的时候，要移除的窗口元素等于该队列的最大值，也就是队列要先移除该该元素,不要让该元素在队列中继续和新加入窗口元素对比
            if (nums[index - k] == myDegreeQueue.peekFirst()) {
                myDegreeQueue.popFist();
                myDegreeQueue.push(nums[index]);
            }
            //当窗口移动的时候，要移除的窗口元素不等于该队列的最大值
            else {
                myDegreeQueue.push(nums[index]);
            }
            res[index - k + 1] = myDegreeQueue.peekFirst();
            index++;
        }


        return res;
    }

    //该队列保证单调递减，但是不保证添加过的元素都保留在队列之中，也就是保持单调递减的过程可能要把添加过的元素移除
    class MyDegreeQueue {
        private LinkedList<Integer> queue;

        public MyDegreeQueue() {
            queue = new LinkedList<>();
        }

        public int popFist() {
            return queue.pollFirst();
        }

        public void push(Integer integer) {
            while (!queue.isEmpty() && integer > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(integer);
        }

        public int peekFirst() {
            return queue.peekFirst();
        }

    }
}

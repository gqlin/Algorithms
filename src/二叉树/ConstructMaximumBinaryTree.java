package 二叉树;


/**
 * @description：递归终止条件
 * @date： 2022/5/7 12:41
 * @author：gqlin
 */
public class ConstructMaximumBinaryTree {

    //题目：654.最大二叉树  https://leetcode-cn.com/problems/maximum-binary-tree/
    //题目分析：https://www.programmercarl.com/0654.%E6%9C%80%E5%A4%A7%E4%BA%8C%E5%8F%89%E6%A0%91.html#java
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    //分割过程保持左闭右开状态
    public TreeNode build(int[] nums, int leftIndex, int rightIndex) {
        /*
         * 对于有返回值的递归：
         *
         * 如何确定终止条件、终止条件的返回值？
         * 递归遍历二叉树的终止条件、终止的时候的返回值，一般是关于叶子节点，也就是遍历的最后一层
         * 所以写递归的终止条件的时候，
         * 可以想象当前递归是在最后一层，最后一层要干些什么，什么条件下终止递归并且返回什么
         *
         * 如何确定非最后一层递归的返回值？
         * 可以想象当前是倒数第二层递归，接收最后一层返回值之后，进行一些操作，然后返回自己的值
         *
         */

        //需要被分割的数组没有元素了
        if ((rightIndex - leftIndex) == 0) {
            return null;
        }

        //需要被分割的数组只剩下一个元素
        if ((rightIndex - leftIndex) == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        int maxValIndex = leftIndex;//最大值的位置
        int maxVal = nums[maxValIndex];//最大值
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxValIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxValIndex]);
        root.left = build(nums, leftIndex, maxValIndex);
        root.right = build(nums, maxValIndex + 1, rightIndex);
        return root;//非最后一层递归的返回值
    }


}

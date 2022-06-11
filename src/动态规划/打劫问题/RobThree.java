package 动态规划.Rob;

import 二叉树.TreeNode;

/**
 * @description：
 * @date： 2022/6/2 16:35
 * @author：gqlin
 */
public class RobThree {
/*    337. 打家劫舍 III
    小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

    除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

    给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。



    示例 1:



    输入: root = [3,2,3,null,3,null,1]
    输出: 7
    解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
    示例 2:



    输入: root = [3,4,5,1,3,null,1]
    输出: 9
    解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9


    提示：

    树的节点数在 [1, 104] 范围内
0 <= Node.val <= 104*/

    //解题步骤：https://programmercarl.com/0337.%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8DIII.html#_337-%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8D-iii

    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    //递归的返回值：int数组，int[0]表示选了当前节点的金额；int[1]表示没有选择当前节点
    public int[] robAction(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        //选择当前节点的值,则当前节点的左右节点都不能选择
        int val1 = root.val + left[1] + right[1];

        //如果不偷当前节点，那么左右孩子就可以偷，至于到底偷不偷一定是选一个最大的，
        // 所以：val2 = max(left[0], left[1]) + max(right[0], right[1]);
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{val1, val2};
    }
}


package 二叉树;


import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @date： 2022/5/4 19:56
 * @author：gqlin
 */
public class PathSum {
    /*    113. 路径总和 II
        给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

        叶子节点 是指没有子节点的节点。



        示例 1：


        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        输出：[[5,4,11,2],[5,8,4,5]]
        示例 2：


        输入：root = [1,2,3], targetSum = 5
        输出：[]
        示例 3：

        输入：root = [1,2], targetSum = 0
        输出：[]*/


    //解题步骤：https://www.programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html#%E9%80%92%E5%BD%92

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        traversal(root, targetSum);
        return res;
    }

    public void traversal(TreeNode cur, int curSum) {
        tempList.add(cur.val);
        int temp = curSum - cur.val;
        if (cur.left == null && cur.right == null) {
            if (temp == 0) {
                ArrayList<Integer> al = new ArrayList<>(tempList);
                res.add(al);
            }
            return;
        }

        if (cur.left != null) {
            traversal(cur.left, temp);
            tempList.remove(tempList.size() - 1);
        }
        if (cur.right != null) {
            traversal(cur.right, temp);
            tempList.remove(tempList.size() - 1);
        }
    }

}

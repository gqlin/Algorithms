package 二叉树;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description：
 * @date： 2022/5/9 11:00
 * @author：gqlin
 */
public class FindMode {

/*    501. 二叉搜索树中的众数
    给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。

    如果树中有不止一个众数，可以按 任意顺序 返回。

    假定 BST 满足如下定义：

    结点左子树中所含节点的值 小于等于 当前节点的值
    结点右子树中所含节点的值 大于等于 当前节点的值
            左子树和右子树都是二叉搜索树


    示例 1：


    输入：root = [1,null,2,2]
    输出：[2]
    示例 2：

    输入：root = [0]
    输出：[0]*/

    //解题步骤：https://www.programmercarl.com/0501.%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E4%B8%AD%E7%9A%84%E4%BC%97%E6%95%B0.html#%E9%80%92%E5%BD%92%E6%B3%95
    ArrayList<Integer> resList = new ArrayList<>();
    TreeNode pre;//防止重复的节点
    int count = 0;//当前数字的频率
    int preCount = 0;//记录resList中数字的最大频率

    public int[] findMode(TreeNode root) {

        findMode1(root);

        int length = resList.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void findMode1(TreeNode root) {
        if (root == null) {
            return;
        }
        findMode1(root.left);
        //处理中序遍历的第一个节点
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > preCount) {
            preCount = count;
            resList.clear();
            resList.add(root.val);
        } else if (count == preCount) {
            resList.add(root.val);
        }
        pre = root;
        findMode1(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(2);
        root.left = null;
        root.right = treeNode;
        findMode1(root);
    }
}

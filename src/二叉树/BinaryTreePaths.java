package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：递归与回溯
 * @date： 2022/5/2 21:41
 * @author：gqlin
 */
public class BinaryTreePaths {
/*
    257. 二叉树的所有路径
    给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

    叶子节点 是指没有子节点的节点。


    示例 1：


    输入：root = [1,2,3,null,5]
    输出：["1->2->5","1->3"]
    示例 2：

    输入：root = [1]
    输出：["1"]*/

    //解题步骤：https://www.programmercarl.com/0257.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%89%80%E6%9C%89%E8%B7%AF%E5%BE%84.html#%E9%80%92%E5%BD%92
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;

    }

    public void traversal(TreeNode cur, List<Integer> paths, List<String> res) {
        paths.add(cur.val);

        if (cur.left == null && cur.right == null) {
            StringBuilder sb = new StringBuilder();
            int size = paths.size();
            int index = 0;
            while (index < (size - 1)) {
                sb.append(paths.get(index++) + "->");
            }
            sb.append(paths.get(size - 1));
            res.add(sb.toString());
            return;
        }

        if (cur.left != null) {
            traversal(cur.left, paths, res);
            paths.remove(paths.size() - 1);
        }
        if (cur.right != null) {
            traversal(cur.right, paths, res);
            paths.remove(paths.size() - 1);
        }
    }
}

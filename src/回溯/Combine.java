package 回溯;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description：回溯-组合问题
 * @date： 2022/5/12 13:22
 * @author：gqlin
 */
public class Combine {
/*    77. 组合
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

    你可以按 任何顺序 返回答案。



    示例 1：

    输入：n = 4, k = 2
    输出：
            [
            [2,4],
            [3,4],
            [2,3],
            [1,2],
            [1,3],
            [1,4],
            ]
    示例 2：

    输入：n = 1, k = 1
    输出：[[1]]*/

    //解题步骤：https://www.programmercarl.com/0077.%E7%BB%84%E5%90%88.html#%E5%9B%9E%E6%BA%AF%E6%B3%95%E4%B8%89%E9%83%A8%E6%9B%B2

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine1(n, k, 1);
        return result;
    }

    private void combine1(int n, int k, int startIndex) {
        //终止条件
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combine1(n, k, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test() {
        combine(4, 2);
    }
}

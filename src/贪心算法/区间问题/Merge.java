package 贪心算法.区间问题;

import org.junit.Test;

import java.util.*;

/**
 * @description：
 * @date： 2022/5/22 17:23
 * @author：gqlin
 */
public class Merge {
/*    56. 合并区间
    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。



    示例 1：

    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    输出：[[1,6],[8,10],[15,18]]
    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    示例 2：

    输入：intervals = [[1,4],[4,5]]
    输出：[[1,5]]
    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。


    提示：

            1 <= intervals.length <= 104
    intervals[i].length == 2
            0 <= starti <= endi <= 104*/

/*    解题思路：
    思路
    大家应该都感觉到了，此题一定要排序，那么按照左边界排序，还是右边界排序呢？

    都可以！

    那么我按照左边界排序，排序之后局部最优：每次合并都取最大的右边界，这样就可以合并更多的区间了，整体最优：合并所有重叠的区间。

    局部最优可以推出全局最优，找不出反例，试试贪心。

    那有同学问了，本来不就应该合并最大右边界么，这和贪心有啥关系？

    有时候贪心就是常识！哈哈

    按照左边界从小到大排序之后，如果 intervals[i][0] < intervals[i - 1][1] 即intervals[i]左边界 < intervals[i - 1]右边界，则一定有重复，因为intervals[i]的左边界一定是大于等于intervals[i - 1]的左边界。

    即：intervals[i]的左边界在intervals[i - 1]左边界和右边界的范围内，那么一定有重复！*/

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                int start = res.getLast()[0];
                int end = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.add(new int[]{start, end});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}

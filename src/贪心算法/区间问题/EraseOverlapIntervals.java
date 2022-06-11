package 贪心算法.区间问题;

import java.util.Arrays;

/**
 * @description：
 * @date： 2022/5/22 10:13
 * @author：gqlin
 */
public class EraseOverlapIntervals {
/*    435. 无重叠区间
    给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。



    示例 1:

    输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
    输出: 1
    解释: 移除 [1,3] 后，剩下的区间没有重叠。
    示例 2:

    输入: intervals = [ [1,2], [1,2], [1,2] ]
    输出: 2
    解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
    示例 3:

    输入: intervals = [ [1,2], [2,3] ]
    输出: 0
    解释: 你不需要移除任何区间，因为它们已经是无重叠的了。


    提示:

            1 <= intervals.length <= 105
    intervals[i].length == 2
            -5 * 104 <= starti < endi <= 5 * 104*/

    //解题步骤：https://www.programmercarl.com/0435.%E6%97%A0%E9%87%8D%E5%8F%A0%E5%8C%BA%E9%97%B4.html#%E6%80%9D%E8%B7%AF

    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;//记录非交叉区间个数
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];//按照区间右边界从小到大排序；
        });
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}

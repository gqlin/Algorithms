package 贪心算法;

/**
 * @description：
 * @date： 2022/5/21 16:56
 * @author：gqlin
 */
public class Candy {
/*    135. 分发糖果
    n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

    你需要按照以下要求，给这些孩子分发糖果：

    每个孩子至少分配到 1 个糖果。
    相邻两个孩子评分更高的孩子会获得更多的糖果。
    请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。



    示例 1：

    输入：ratings = [1,0,2]
    输出：5
    解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
    示例 2：

    输入：ratings = [1,2,2]
    输出：4
    解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
    第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。


    提示：

    n == ratings.length
1 <= n <= 2 * 104
            0 <= ratings[i] <= 2 * 104*/

    //解题思路：https://www.programmercarl.com/0135.%E5%88%86%E5%8F%91%E7%B3%96%E6%9E%9C.html#%E6%80%9D%E8%B7%AF
/*
    这道题目一定是要确定一边之后，再确定另一边，例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑一定会顾此失彼。

    先确定右边评分大于左边的情况（也就是从前向后遍历）

    此时局部最优：只要右边评分比左边大，右边的孩子就多一个糖果，全局最优：相邻的孩子中，评分高的右孩子获得比左边孩子更多的糖果

    局部最优可以推出全局最优。

    如果ratings[i] > ratings[i - 1] 那么[i]的糖 一定要比[i - 1]的糖多一个，所以贪心：candyVec[i] = candyVec[i - 1] + 1

    代码如下：
            // 从前向后
            for (int i = 1; i < ratings.size(); i++) {
                if (ratings[i] > ratings[i - 1]) candyVec[i] = candyVec[i - 1] + 1;
            }

    再确定左孩子大于右孩子的情况（从后向前遍历）

    遍历顺序这里有同学可能会有疑问，为什么不能从前向后遍历呢？

    因为如果从前向后遍历，根据 ratings[i + 1] 来确定 ratings[i] 对应的糖果，那么每次都不能利用上前一次的比较结果了。

    所以确定左孩子大于右孩子的情况一定要从后向前遍历！

    如果 ratings[i] > ratings[i + 1]，此时candyVec[i]（第i个小孩的糖果数量）就有两个选择了，一个是candyVec[i + 1] + 1（从右边这个加1得到的糖果数量），一个是candyVec[i]（之前比较右孩子大于左孩子得到的糖果数量）。

    那么又要贪心了，局部最优：取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，保证第i个小孩的糖果数量即大于左边的也大于右边的。全局最优：相邻的孩子中，评分高的孩子获得更多的糖果。

    局部最优可以推出全局最优。

    所以就取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，candyVec[i]只有取最大的才能既保持对左边candyVec[i - 1]的糖果多，也比右边candyVec[i + 1]的糖果多。*/


    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        //先从左往右遍历，确保右边分值大的同学，都能分到比左边更多的糖果
        for (int i = 1; i < ratings.length; i++) {
            candyVec[i] = ratings[i] > ratings[i - 1] ? candyVec[i - 1] + 1 : 1;
        }
        //从右往左遍历（上面从左往右遍历中，只找出了右边比左边大的情况，然而当左边比右边大时候，左边直接赋值为了1）
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //所以就取candyVec[i + 1] + 1 和 candyVec[i] 最大的糖果数量，candyVec[i]只有取最大的才能既保持对左边candyVec[i - 1]的糖果多，也比右边candyVec[i + 1]的糖果多。
                candyVec[i] = Math.max(candyVec[i], candyVec[i + 1] + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result += candyVec[i];
        }
        return result;
    }
}

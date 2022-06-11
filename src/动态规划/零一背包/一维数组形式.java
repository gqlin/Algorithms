package 动态规划.ZeroOneBag;

/**
 * @description：
 * @date： 2022/5/27 22:33
 * @author：gqlin
 */
public class 一维数组形式 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            //打印dp数组
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[j] + "\t");
            }
            System.out.println();
        }
    }
}

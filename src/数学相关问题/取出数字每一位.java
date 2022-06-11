package 数学相关问题;

/**
 * @description：
 * @date： 2022/4/17 22:23
 * @author：gqlin
 */
public class 取出数字每一位 {
    public int nextNum(int num) {
        int sum = 0;
        while (num > 0) {
            int bit = num % 10;
            sum += bit * bit;
            num = num / 10;
        }
        return sum;
    }
}

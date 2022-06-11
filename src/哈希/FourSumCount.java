package 哈希;

import java.util.HashMap;

/**
 * @description：
 * @date： 2022/4/25 14:44
 * @author：gqlin
 */
public class FourSumCount {
/*
    454. 四数相加 II
    给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：

            0 <= i, j, k, l < n
    nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


    示例 1：

    输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
    输出：2
    解释：
    两个元组如下：
            1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
            2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
    示例 2：

    输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
    输出：1*/

//    本题解题步骤：
//
//    首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
//    遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
//    定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
//    在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
//    最后返回统计值 count 就可以了

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Integer length = nums1.length;
        HashMap<Integer, Integer> hashMap = new HashMap(10);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Integer result = nums1[i] + nums2[j];
                Integer tempCount = hashMap.get(result);
                hashMap.put(result, tempCount == null ? 1 : ++tempCount);
            }
        }
        Integer count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Integer result = nums3[i] + nums4[j];
                if (hashMap.containsKey(0 - result)) {
                    count += hashMap.get(0 - result);
                }
            }
        }

        return count.intValue();
    }

}

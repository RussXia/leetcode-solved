package com.xzy.leetcode._301_600;

/**
 * @author xiazhengyue
 * @since 2021-04-18
 */
public class Solution_560 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subarraySum(nums, 3));
    }

    /**
     * sum(i,j) = sum(0,j)-sum(0,i);
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int[] sumDict = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumDict[i] = sum;
        }
        int count = 0;
        for (int i = 0; i < sumDict.length; i++) {
            if (sumDict[i] == k) {
                count++;
            }
        }
        //统计和为k的个数
        for (int i = 0; i < sumDict.length; i++) {
            for (int j = i + 1; j < sumDict.length; j++) {
                if (sumDict[j] - sumDict[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}

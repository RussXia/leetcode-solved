package com.xzy.leetcode._1201_2000;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * User: RuzzZZ
 * Date: 2023/5/6
 * Time: 14:24
 */
public class Solution_1498 {

    public static void main(String[] args) {
        //int[] nums = {1, 1, 2, 3, 4, 6, 9, 9};
        //int target = 6;
        //int[] nums = {3, 5, 6, 7};
        //int target = 9;
        //int[] nums = {2,3,3,4,6,7};
        //int target = 12;
        int[] nums = {9, 25, 9, 28, 24, 12, 17, 8, 28, 7, 21, 25, 10, 2, 16, 19, 12, 13, 15, 28, 14, 12, 24, 9, 6, 7, 2, 15, 19, 13, 30, 30, 23, 19, 11, 3, 17, 2, 14, 20, 22, 30, 12, 1, 11, 2, 2, 20, 20, 27, 15, 9, 10, 4, 12, 30, 13, 5, 2, 11, 29, 5, 3, 13, 22, 5, 16, 19, 7, 19, 11, 16, 11, 25, 29, 21, 29, 3, 2, 9, 20, 15, 9};
        int target = 32;
        System.out.println(numSubseq(nums, target));
        System.out.println((long) Math.pow(2, 82));
        System.out.println(BigDecimal.valueOf(Math.pow(2, 82)).toBigInteger());
    }

    public static int numSubseq(int[] nums, int target) {
        // sort array first
        Arrays.sort(nums);

        BigInteger total = new BigInteger("0");
        BigInteger logarithm = new BigInteger("2");
        BigInteger mod = new BigInteger("1000000007");
        // two point to find the most elements
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[end] + nums[start] > target) {
                end--;
                continue;
            }
            // start+1-->end sub_array
            total = total.add(logarithm.pow(end - start)).mod(mod);
            start++;
        }
        return total.mod(mod).intValue();
    }
}

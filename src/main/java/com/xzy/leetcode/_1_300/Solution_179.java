package com.xzy.leetcode._1_300;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xiazhengyue
 * @since 2021-04-14
 */
public class Solution_179 {

    public static void main(String[] args) {
        Solution_179 solution = new Solution_179();
        {
            //43243 > 432  --> desc
            int[] nums = {432, 43243};
            System.out.println(solution.largestNumber2(nums));

            //457 > 45745  --> asc
            int[] nums1 = {457, 45745};
            System.out.println(solution.largestNumber2(nums1));

            //451 < 45145  --> desc
            int[] nums2 = {451, 45145};
            System.out.println(solution.largestNumber2(nums2));

            //5335 == 533553 --> flat
            int[] nums3 = {5335, 533553};
            System.out.println(solution.largestNumber2(nums3));

            int[] num4 = {3, 341, 302, 5, 9};
            System.out.println(solution.largestNumber2(num4));

            int[] num5 = {0, 0};
            System.out.println(solution.largestNumber(num5));
        }
    }

    public String largestNumber2(int[] num) {
        if (num == null || num.length == 0)
            return "";

        String[] str = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            str[i] = String.valueOf(num[i]);
        }

        Comparator<String> comparator = (str1, str2) -> {
            String temp1 = str1 + str2;
            String temp2 = str2 + str1;
            return temp2.compareTo(temp1);
        };
        Arrays.sort(str, comparator);

        //处理一下特殊情况
        if (str[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String largestNumber(int[] nums) {
        //sort by the first number

        nums = sortByFirstNumber(nums);

        //concat as a string
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        String str = sb.toString();
        if (str.charAt(0) == '0') {
            return "0";
        }
        return str;
    }

    private int[] sortByFirstNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                if (compare(nums[i], nums[j]) < 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    private int compare(int num1, int num2) {
        String str1 = String.valueOf(num1) + num2;
        String str2 = String.valueOf(num2) + num1;
        return Long.valueOf(str1).compareTo(Long.valueOf(str2));
    }
}

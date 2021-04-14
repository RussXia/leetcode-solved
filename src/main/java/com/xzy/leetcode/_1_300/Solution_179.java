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
            System.out.println(solution.largestNumber(nums));

            //457 > 45745  --> asc
            int[] nums1 = {457, 45745};
            System.out.println(solution.largestNumber(nums1));

            //451 < 45145  --> desc
            int[] nums2 = {451, 45145};
            System.out.println(solution.largestNumber(nums2));

            //5335 == 533553 --> flat
            int[] nums3 = {5335, 533553};
            System.out.println(solution.largestNumber(nums3));

            int[] num4 = {3, 341, 302, 5, 9};
            System.out.println(solution.largestNumber(num4));

            int[] num5 = {0, 0};
            System.out.println(solution.largestNumber(num5));
        }
    }

    public String largestNumber2(int[] num) {
        if (num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for (int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };

        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : s_num)
            sb.append(s);

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

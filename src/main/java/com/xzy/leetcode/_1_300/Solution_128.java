package com.xzy.leetcode._1_300;

import java.util.stream.IntStream;

public class Solution_128 {


    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
//        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int length = 1;
        int[] sortedArray = IntStream.of(nums).sorted().distinct().toArray();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int temp = 1;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] - sortedArray[j - 1] == 1) {
                    temp++;
                    continue;
                }
                break;
            }
            if (temp > length) {
                length = temp;
            }
        }
        return length;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int length = 1;
        int temp = 1;
        int[] sortedArr = IntStream.of(nums).sorted().distinct().toArray();
        for (int i = 0; i < sortedArr.length - 1; i++) {
            if (sortedArr[i + 1] - sortedArr[i] == 1) {
                temp++;
            } else {
                temp = 1;
                continue;
            }
            if (temp > length) {
                length = temp;
            }
        }
        return length;
    }
}

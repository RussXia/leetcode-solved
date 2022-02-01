package com.xzy.leetcode._1_300;

import com.alibaba.fastjson.JSON;

/**
 * User: RuzzZZ
 * Date: 2022/2/1
 * Time: 22:59
 */
public class Solution_167 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        System.out.println(JSON.toJSONString(twoSumV3(nums, target)));
    }

    /**
     * O(n^2)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumV1(int[] numbers, int target) {
        for (int first = 0; first < numbers.length; first++) {
            for (int second = first + 1; second < numbers.length; second++) {
                if (numbers[first] + numbers[second] == target) {
                    return new int[]{first + 1, second + 1};
                } else if (numbers[first] + numbers[second] > target) {
                    break;
                }
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * O(nlogn)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumV2(int[] numbers, int target) {
        for (int first = 0; first < numbers.length; first++) {
            //考虑采用二分法
        }
        return new int[]{-1, -1};
    }

    /**
     * 双指针，O(n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumV3(int[] numbers, int target) {
        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] == target) {
                return new int[]{head + 1, tail + 1};
            } else if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                head++;
            }
        }
        return new int[]{-1, -1};
    }
}

package com.xzy.leetcode._1_300;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiazhengyue
 * @since 2021-04-09
 */
public class Solution_169 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3};
        System.out.println(majorityElement2(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> dict = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            dict.compute(nums[i], (key, oldValue) -> {
                if (oldValue == null) {
                    return 1;
                }
                return oldValue + 1;
            });
        }
        return dict.entrySet().stream()
                .filter(number -> nums.length % 2 == 0
                        ? number.getValue() >= (nums.length / 2)
                        : number.getValue() >= (nums.length / 2 + 1))
                .findAny().get().getKey();
    }

    /**
     * major元素出现次数超过n/2次，所以major元素和其他元素对掉(消消乐)，最后剩下的元素一定还是major
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}

package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2019-11-05
 */
public class MoveZeroes_283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int insert = 0;
        for (int num : nums) {
            if (num == 0) {
                nums[insert++] = 0;
            }
        }
        for (int i = insert; i < nums.length; i++) {
            nums[insert++] = 0;
        }

//        recursiveMoveZeroes(nums, 0);
    }

    private static void recursiveMoveZeroes(int[] nums, int start) {
        if (start >= nums.length - 1) {
            return;
        }
        if (nums[start] != 0) {
            recursiveMoveZeroes(nums, start + 1);
        } else {
            //如果为0，找寻后继不为0的元素，替换过来
            for (int i = start + 1; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            recursiveMoveZeroes(nums, start + 1);
        }
    }
}

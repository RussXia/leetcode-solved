package com.xzy.interview;

import com.alibaba.fastjson.JSON;

public class LeetCode_27 {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(JSON.toJSONString(nums));
    }


    public static int removeElement(int[] nums, int val) {
        int count = 0;
        int point = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[point] = nums[i];
                point++;
                count++;
            }
        }
        return count;
    }
}

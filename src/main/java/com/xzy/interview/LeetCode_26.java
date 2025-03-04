package com.xzy.interview;

import com.alibaba.fastjson.JSON;

public class LeetCode_26 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int result = new LeetCode_26().removeDuplicates(nums);
        System.out.println(result);
        System.out.println("========================================");
        System.out.println(JSON.toJSONString(nums));
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int point = 0;
        int k = 0;
        int pre = 0, next = 1;
        while (next < nums.length) {
            if (nums[pre] != nums[next]) {
                nums[point] = nums[pre];
                point++;
                pre = next;
                next++;
                k++;
            } else {
                next++;
            }
        }
        if (pre - 1 >= 0 && nums[pre] != nums[pre - 1]) {
            nums[point] = nums[pre];
            point++;
            k++;
        }
        return Math.max(1, k);
    }
}

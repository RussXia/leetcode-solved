package com.xzy.leetcode._1_300;

import java.util.ArrayList;
import java.util.List;

/**
 * User: RuzzZZ
 * Date: 2023/6/12
 * Time: 14:19
 */
public class Solution_228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int start = 0, end = 1;
        List<String> result = new ArrayList<>();
        while (end <= nums.length - 1) {
            if (nums[end] - nums[end - 1] == 1) {
                end++;
                continue;
            }
            String sb = start == (end - 1) ? nums[start] + "" : nums[start] + "->" + nums[end - 1];
            result.add(sb);
            start = end;
            end++;
        }
        result.add(start == (end - 1) ? nums[start] + "" : nums[start] + "->" + nums[end - 1]);
        return result;
    }
}

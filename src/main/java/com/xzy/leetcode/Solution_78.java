package com.xzy.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-03-31
 */
public class Solution_78 {
    public static void main(String[] args) {
        Solution_78 solution = new Solution_78();
        int[] nums = {0,1};
        System.out.println(JSON.toJSON(solution.subsets(nums)));
    }

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subSet(nums, new ArrayList<>(), 0, result);
        return result;
    }

    private void subSet(int[] nums, List<Integer> temp, int startIndex, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            subSet(nums, temp, i + 1, result);
            temp.remove(temp.size() - 1);
        }
    }
}

package com.xzy.leetcode._1_300;

/**
 * User: RuzzZZ
 * Date: 2024/7/29
 * Time: 15:11
 */
public class Solution_11 {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

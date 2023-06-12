package com.xzy.leetcode._1201_2000;

/**
 * User: RuzzZZ
 * Date: 2023/6/8
 * Time: 10:40
 */
public class Solution_1351 {
    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -2, -3, -4},
        };
        Solution_1351 solution1351 = new Solution_1351();
        System.out.println(solution1351.countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            int index = firstNegativeIndex(grid[row], 0);
            count += index >= 0 ? grid[row].length - index : 0;
        }
        return count;
    }

    public int countNegatives2(int[][] grid) {
        int count = 0;
        // 上一层的负数的index
        int lastNegativeIndex = 0;
        for (int row = 0; row < grid.length; row++) {
            int index = firstNegativeIndex(grid[row], lastNegativeIndex);
            count += index >= 0 ? grid[row].length - index : 0;
        }
        return count;
    }

    private int firstNegativeIndex(int[] arr, int startIndex) {
        if (arr[startIndex] < 0) {
            for (int i = startIndex; i >= 0; i--) {
                if (arr[i] > 0) return i + 1;
            }
            return 0;
        } else {
            for (int i = startIndex; i < arr.length; i++) {
                if (arr[i] < 0) return i;
            }
            return -1;
        }
    }
}

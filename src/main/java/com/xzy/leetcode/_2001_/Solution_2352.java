package com.xzy.leetcode._2001_;

import java.util.Arrays;
import java.util.HashMap;

/**
 * User: RuzzZZ
 * Date: 2023/6/13
 * Time: 10:53
 */
public class Solution_2352 {


    public int equalPairs2(int[][] grid) {
        int count = 0;
        HashMap<String, Integer> rowString = new HashMap<>();
        for (int row = 0; row < grid.length; row++) {
            rowString.merge(Arrays.toString(grid[row]), 1, Integer::sum);
        }
        for (int col = 0; col < grid[0].length; col++) {
            int[] arr = new int[grid.length];
            for (int row = 0; row < grid.length; row++) {
                arr[row] = grid[row][col];
            }
            count += rowString.getOrDefault(Arrays.toString(arr),0);
        }
        return count;
    }

    public int equalPairs(int[][] grid) {
        int count = 0;
        HashMap<String, Integer> colStrings = new HashMap<>();
        for (int col = 0; col < grid[0].length; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < grid.length; row++) {
                sb.append(grid[row][col]).append("-");
            }
            colStrings.put(sb.toString(), colStrings.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int row = 0; row < grid.length; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < grid[0].length; col++) {
                sb.append(grid[row][col]).append("-");
            }
            if (colStrings.containsKey(sb.toString())) {
                count += colStrings.get(sb.toString());
            }
        }
        return count;
    }
}

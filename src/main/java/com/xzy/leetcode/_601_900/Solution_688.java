package com.xzy.leetcode._601_900;

import java.util.HashSet;
import java.util.Set;

/**
 * User: RuzzZZ
 * Date: 2022/2/17
 * Time: 15:49
 */
public class Solution_688 {

    public static void main(String[] args) {
        int pair = 15 << 6 | 15;
        int tempRow = pair >> 6;
        int tempCol = pair ^ (tempRow << 6);
        System.out.println(tempRow);
        System.out.println(tempCol);
        //Solution_688 solution_688 = new Solution_688();
        //System.out.println(solution_688.knightProbability(25, 100, 15, 15));
    }

    /**
     * dp[n][m] = 0 (default = 0)
     * dp[row][col] = 1
     * dp[row+2][col+1] =  1/8
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        //记录上次元素所在的地方
        Set<Integer> set = new HashSet<>();
        set.add(row << 6 | column);
        dp[row][column] = 1;
        for (int i = 1; i <= k; i++) {
            Set<Integer> tempSet = new HashSet<>();
            double[][] temp = new double[n][n];
            for (Integer pair : set) {
                int tempRow = pair >> 6;
                int tempCol = pair ^ (tempRow << 6);
                double probability = dp[tempRow][tempCol];
                if (tempRow - 2 >= 0 && tempCol - 1 >= 0) {
                    temp[tempRow - 2][tempCol - 1] += probability * 0.125;
                    tempSet.add((tempRow - 2) << 6 | (tempCol - 1));
                }
                if (tempRow - 2 >= 0 && tempCol + 1 < n) {
                    temp[tempRow - 2][tempCol + 1] += probability * 0.125;
                    tempSet.add((tempRow - 2) << 6 | (tempCol + 1));
                }
                if (tempCol - 1 >= 0 && tempRow + 2 < n) {
                    temp[tempRow + 2][tempCol - 1] += probability * 0.125;
                    tempSet.add((tempRow + 2) << 6 | (tempCol - 1));
                }
                if (tempRow + 2 < n && tempCol + 1 < n) {
                    temp[tempRow + 2][tempCol + 1] += probability * 0.125;
                    tempSet.add((tempRow + 2) << 6 | (tempCol + 1));
                }
                if (tempRow - 1 >= 0 && tempCol - 2 >= 0) {
                    temp[tempRow - 1][tempCol - 2] += probability * 0.125;
                    tempSet.add((tempRow - 1) << 6 | (tempCol - 2));
                }
                if (tempRow - 1 >= 0 && tempCol + 2 < n) {
                    temp[tempRow - 1][tempCol + 2] += probability * 0.125;
                    tempSet.add((tempRow - 1) << 6 | (tempCol + 2));
                }
                if (tempCol - 2 >= 0 && tempRow + 1 < n) {
                    temp[tempRow + 1][tempCol - 2] += probability * 0.125;
                    tempSet.add((tempRow + 1) << 6 | (tempCol - 2));
                }
                if (tempRow + 1 < n && tempCol + 2 < n) {
                    temp[tempRow + 1][tempCol + 2] += probability * 0.125;
                    tempSet.add((tempRow + 1) << 6 | (tempCol + 2));
                }
            }
            dp = temp;
            set = tempSet;
        }
        double result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
            }
        }
        return result;
    }

}

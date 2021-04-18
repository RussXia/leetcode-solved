package com.xzy.leetcode._901_1200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiazhengyue
 * @since 2021-04-17
 */
public class Solution_1074 {

    public static void main(String[] args) {
        {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println(numSubmatrixSumTarget(matrix, 11));
        }
        {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            System.out.println(numSubmatrixSumTarget2(matrix, 11));
        }

    }

    public static int numSubmatrixSumTarget2(int[][] A, int target) {
        int res = 0, m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                A[i][j] += A[i][j - 1];
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += A[k][j] - (i > 0 ? A[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }

    /**
     * [1, 3, 6]
     * [4, 9,15]
     * [7,15,24]
     *
     * @param matrix
     * @param target
     * @return
     */
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0, row = matrix.length, col = matrix[0].length;
        //各行前缀和
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = i; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    int subSum = 0; //子矩阵之和
                    for (int l = k; l < row; l++) {
                        //这一行，i-j列的和
                        int colSum = matrix[l][j] - (i > 0 ? matrix[l][i - 1] : 0);
                        subSum += colSum;
                        if (subSum == target) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
